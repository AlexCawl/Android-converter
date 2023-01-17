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
        map.put(binding.container.layoutContent.etInch, LengthType.INCHES);
        map.put(binding.container.layoutContent.etYard, LengthType.YARDS);
        map.put(binding.container.layoutContent.etFoot, LengthType.FEET);
        map.put(binding.container.layoutContent.etMile, LengthType.MILES);
        map.put(binding.container.layoutContent.etYottametre, LengthType.YOTTAMETRES);
        map.put(binding.container.layoutContent.etZettametre, LengthType.ZETTAMETRES);
        map.put(binding.container.layoutContent.etExametre, LengthType.EXAMETRES);
        map.put(binding.container.layoutContent.etPetametre, LengthType.PETAMETRES);
        map.put(binding.container.layoutContent.etTerametre, LengthType.TERAMETRES);
        map.put(binding.container.layoutContent.etGigametre, LengthType.GIGAMETRES);
        map.put(binding.container.layoutContent.etMegametre, LengthType.MEGAMETRES);
        map.put(binding.container.layoutContent.etKilometre, LengthType.KILOMETRES);
        map.put(binding.container.layoutContent.etHectometre, LengthType.HECTOMETRES);
        map.put(binding.container.layoutContent.etDecametre, LengthType.DECAMETRES);
        map.put(binding.container.layoutContent.etMetre, LengthType.METRES);
        map.put(binding.container.layoutContent.etDecimetre, LengthType.DECIMETRES);
        map.put(binding.container.layoutContent.etCentimetre, LengthType.CENTIMETRES);
        map.put(binding.container.layoutContent.etMillimetre, LengthType.MILLIMETRES);
        map.put(binding.container.layoutContent.etMicrometre, LengthType.MICROMETRES);
        map.put(binding.container.layoutContent.etNanometre, LengthType.NANOMETRES);
        map.put(binding.container.layoutContent.etPicometre, LengthType.PICOMETRES);
        map.put(binding.container.layoutContent.etFemtometre, LengthType.FEMTOMETRES);
        map.put(binding.container.layoutContent.etAttometre, LengthType.ATTOMETRES);
        map.put(binding.container.layoutContent.etZeptometre, LengthType.ZEPTOMETRES);
        map.put(binding.container.layoutContent.etYoctometre, LengthType.YOCTOMETRES);
        return map;
    }
}
