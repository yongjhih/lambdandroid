package android.text;

public class LambdaTextWatcher implements TextWatcher {
    @Override
    public void afterTextChanged(Editable s) {
        if (afterTextChanged == null) return;
        afterTextChanged.call(s);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (beforeTextChanged == null) return;
        beforeTextChanged.call(s, start, count, after);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (onTextChanged == null) return;
        onTextChanged.call(s, start, before, count);
    }

    Action1<Editable> afterTextChanged;
    Action4<CharSequence, Integer, Integer, Integer> beforeTextChanged;
    Action4<CharSequence, Integer, Integer, Integer> onTextChanged;

    public LambdaTextWatcher afterTextChanged(Action1<Editable> afterTextChanged) {
        this.afterTextChanged = afterTextChanged;
        return this;
    }

    public LambdaTextWatcher beforeTextChanged(Action4<CharSequence, Integer, Integer, Integer> beforeTextChanged) {
        this.beforeTextChanged = beforeTextChanged;
        return this;
    }

    public LambdaTextWatcher onTextChanged(Action4<CharSequence, Integer, Integer, Integer> onTextChanged) {
        this.onTextChanged = onTextChanged;
        return this;
    }

    public static LambdaTextWatcher on(Action1<Editable> afterTextChanged) {
        return new LambdaTextWatcher().afterTextChanged(afterTextChanged);
    }

    public static LambdaTextWatcher on(Action1<Editable> afterTextChanged, Action4<CharSequence, Integer, Integer, Integer> onTextChanged) {
        return new LambdaTextWatcher().afterTextChanged(afterTextChanged).onTextChanged(onTextChanged);
    }

    public static LambdaTextWatcher on(Action1<Editable> afterTextChanged, Action4<CharSequence, Integer, Integer, Integer> onTextChanged, Action4<CharSequence, Integer, Integer, Integer> beforeTextChanged) {
        return new LambdaTextWatcher().afterTextChanged(afterTextChanged).onTextChanged(onTextChanged).beforeTextChanged(beforeTextChanged);
    }

    interface Action1<T> {
        void call(T t);
    }

    interface Action4<T, T2, T3, T4> {
        void call(T t, T2 t2, T3 t3, T4 t4);
    }
}
