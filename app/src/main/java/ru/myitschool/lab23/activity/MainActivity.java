package ru.myitschool.lab23.activity;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.myitschool.lab23.controller.listener.ConverterListener;
import ru.myitschool.lab23.controller.consumer.Handler;
import ru.myitschool.lab23.controller.locker.ILocker;
import ru.myitschool.lab23.controller.locker.Locker;
import ru.myitschool.lab23.controller.producer.IProducer;
import ru.myitschool.lab23.controller.producer.ProducerService;
import ru.myitschool.lab23.controller.watcher.ConverterWatcher;
import ru.myitschool.lab23.databinding.ActivityMainBinding;
import ru.myitschool.lab23.model.LengthType;
import ru.myitschool.lab23.model.NoMetricaDataException;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Map<LengthType, Pair<TextView, EditText>> configData = init();
        List<Handler> handlers = initHandlers(configData);

        ILocker locker = new Locker();
        IProducer producer = new ProducerService(handlers, locker);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        Map<EditText, ConverterWatcher> watchers = initWatchers(configData, producer, locker);
        watchers.forEach(TextView::addTextChangedListener);

        Map<TextView, ConverterListener> listeners = initListeners(configData, clipboard);
        listeners.forEach(View::setOnClickListener);
    }

    /**
     * Инициализация ConvertListener, необходимых для копирования значения числа из ячейки.
     * */
    private Map<TextView, ConverterListener> initListeners(Map<LengthType, Pair<TextView, EditText>> configData, ClipboardManager clipboard) {
        Map<TextView, ConverterListener> map = new HashMap<>();
        configData.forEach((k, v) -> map.put(v.first, new ConverterListener(v.second, clipboard, k)));
        return map;
    }

    /**
     * Инициализация Handler, необходимых для смены значения числа в ячейке.
     * */
    private List<Handler> initHandlers(Map<LengthType, Pair<TextView, EditText>> configData) {
        List<Handler> list = new ArrayList<>();
        configData.forEach((k, v) -> {
            try {
                list.add(new Handler(v.second, k));
            } catch (NoMetricaDataException e) {
                System.out.println("WARN | No metrica data exception! In initHandlers | " + k.name());
            }
        });
        return list;
    }

    /**
     * Инициализация ConvertWatcher, необходимых для отслеживания изменения значения числа в ячейке.
     * */
    private Map<EditText, ConverterWatcher> initWatchers(Map<LengthType, Pair<TextView, EditText>> configData, IProducer producer, ILocker locker) {
        Map<EditText, ConverterWatcher> map = new HashMap<>();
        configData.forEach((k, v) -> {
            try {
                map.put(v.second, new ConverterWatcher(producer, locker, k));
            } catch (NoMetricaDataException e) {
                System.out.println("WARN | No metrica data exception! In initWatchers | " + k.name());
            }
        });
        return map;
    }

    /**
     * Сопоставление виджетов и их типов.
     * */
    private Map<LengthType, Pair<TextView, EditText>> init() {
        Map<LengthType, Pair<TextView, EditText>> map = new HashMap<>();
        map.put(LengthType.INCHES, Pair.create(binding.container.layoutContent.tvInch, binding.container.layoutContent.etInch));
        map.put(LengthType.YARDS, Pair.create(binding.container.layoutContent.tvYard, binding.container.layoutContent.etYard));
        map.put(LengthType.FEET, Pair.create(binding.container.layoutContent.tvFoot, binding.container.layoutContent.etFoot));
        map.put(LengthType.MILES, Pair.create(binding.container.layoutContent.tvMile, binding.container.layoutContent.etMile));
        map.put(LengthType.YOTTAMETRES, Pair.create(binding.container.layoutContent.tvYottametre, binding.container.layoutContent.etYottametre));
        map.put(LengthType.ZETTAMETRES, Pair.create(binding.container.layoutContent.tvZettametre, binding.container.layoutContent.etZettametre));
        map.put(LengthType.EXAMETRES, Pair.create(binding.container.layoutContent.tvExametre, binding.container.layoutContent.etExametre));
        map.put(LengthType.PETAMETRES, Pair.create(binding.container.layoutContent.tvPetametre, binding.container.layoutContent.etPetametre));
        map.put(LengthType.TERAMETRES, Pair.create(binding.container.layoutContent.tvTerametre, binding.container.layoutContent.etTerametre));
        map.put(LengthType.GIGAMETRES, Pair.create(binding.container.layoutContent.tvGigametre, binding.container.layoutContent.etGigametre));
        map.put(LengthType.MEGAMETRES, Pair.create(binding.container.layoutContent.tvMegametre, binding.container.layoutContent.etMegametre));
        map.put(LengthType.KILOMETRES, Pair.create(binding.container.layoutContent.tvKilometre, binding.container.layoutContent.etKilometre));
        map.put(LengthType.HECTOMETRES, Pair.create(binding.container.layoutContent.tvHectometre, binding.container.layoutContent.etHectometre));
        map.put(LengthType.DECAMETRES, Pair.create(binding.container.layoutContent.tvDecametre, binding.container.layoutContent.etDecametre));
        map.put(LengthType.METRES, Pair.create(binding.container.layoutContent.tvMetre, binding.container.layoutContent.etMetre));
        map.put(LengthType.DECIMETRES, Pair.create(binding.container.layoutContent.tvDecimetre, binding.container.layoutContent.etDecimetre));
        map.put(LengthType.CENTIMETRES, Pair.create(binding.container.layoutContent.tvCentimetre, binding.container.layoutContent.etCentimetre));
        map.put(LengthType.MILLIMETRES, Pair.create(binding.container.layoutContent.tvMillimetre, binding.container.layoutContent.etMillimetre));
        map.put(LengthType.MICROMETRES, Pair.create(binding.container.layoutContent.tvMicrometre, binding.container.layoutContent.etMicrometre));
        map.put(LengthType.NANOMETRES, Pair.create(binding.container.layoutContent.tvNanometre, binding.container.layoutContent.etNanometre));
        map.put(LengthType.PICOMETRES, Pair.create(binding.container.layoutContent.tvPicometre, binding.container.layoutContent.etPicometre));
        map.put(LengthType.FEMTOMETRES, Pair.create(binding.container.layoutContent.tvFemtometre, binding.container.layoutContent.etFemtometre));
        map.put(LengthType.ATTOMETRES, Pair.create(binding.container.layoutContent.tvAttometre, binding.container.layoutContent.etAttometre));
        map.put(LengthType.ZEPTOMETRES, Pair.create(binding.container.layoutContent.tvZeptometre, binding.container.layoutContent.etZeptometre));
        map.put(LengthType.YOCTOMETRES, Pair.create(binding.container.layoutContent.tvYoctometre, binding.container.layoutContent.etYoctometre));
        return map;
    }
}
