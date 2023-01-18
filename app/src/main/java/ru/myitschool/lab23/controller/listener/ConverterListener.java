package ru.myitschool.lab23.controller.listener;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

import ru.myitschool.lab23.model.LengthType;

public class ConverterListener implements View.OnClickListener {
    private final EditText editText;
    private final ClipboardManager clipboard;
    private final LengthType label;

    public ConverterListener(EditText editText, ClipboardManager clipboard, LengthType label) {
        this.editText = editText;
        this.clipboard = clipboard;
        this.label = label;
    }

    @Override
    public void onClick(View view) {
        Editable text = this.editText.getEditableText();
        String label = this.label.name().toLowerCase(Locale.ROOT);
        ClipData clip = ClipData.newPlainText(label, text);
        clipboard.setPrimaryClip(clip);
    }
}
