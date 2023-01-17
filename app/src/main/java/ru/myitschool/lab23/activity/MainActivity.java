package ru.myitschool.lab23.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.myitschool.lab23.controller.locker.ILocker;
import ru.myitschool.lab23.controller.locker.Locker;
import ru.myitschool.lab23.controller.watcher.ConverterWatcher;
import ru.myitschool.lab23.controller.producer.IProducer;
import ru.myitschool.lab23.model.LengthType;
import ru.myitschool.lab23.model.NoMetricaDataException;
import ru.myitschool.lab23.controller.consumer.Handler;
import ru.myitschool.lab23.controller.producer.ProducerService;
import ru.myitschool.lab23.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ProducerService producerService;

    /*
    * Реализовать систему почтовой службы
    * Сделать отдельный сервис по переводу из любой в любую ИЛИ сделать обработчик для каждой величины, которая переводит из метров в себя и из себя в метры
    * Когда нажимается на любую кнопку и записывается число, то в списке всех подписанных на событие обработчиков выполняется метод
    * */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Map<EditText, LengthType> relations = initRelations();
        List<Handler> handlers = initHandlers(relations);
        ILocker locker = new Locker();
        this.producerService = new ProducerService(handlers, locker);
        Map<EditText, ConverterWatcher> watchers = initWatchers(relations, this.producerService, locker);
        watchers.forEach(TextView::addTextChangedListener);
    }

    private List<Handler> initHandlers(Map<EditText, LengthType> relation) {
        List<Handler> list = new ArrayList<>();
        relation.forEach((k, v) -> {
            try {
                list.add(new Handler(k, v));
            } catch (NoMetricaDataException e) {
                System.out.println("Big shit bro!");
            }
        });
        return list;
    }

    private Map<EditText, ConverterWatcher> initWatchers(Map<EditText, LengthType> relation, IProducer producer, ILocker locker) {
        Map<EditText, ConverterWatcher> map = new HashMap<>();
        relation.forEach((k, v) -> map.put(k, new ConverterWatcher(producer, locker, v)));
        return map;
    }

    private Map<EditText, LengthType> initRelations() {
        Map<EditText, LengthType> map = new HashMap<>();
        map.put(binding.container.etMile, LengthType.MILE);
        map.put(binding.container.etMetre, LengthType.METRE);
        map.put(binding.container.etFoot, LengthType.FEET);
        return map;
    }
}
