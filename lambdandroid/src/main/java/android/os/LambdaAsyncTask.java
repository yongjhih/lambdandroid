package android.os;

public class LambdaAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public LambdaAsyncTask() {
        super();
    }

    @Override
    protected Result doInBackground(Params... params) {
        if (doInBackground == null) return null;
        return doInBackground.call(params);
    }

    @Override
    protected void onProgressUpdate(Progress... progress) {
        if (onProgressUpdate == null) return;
        onProgressUpdate(progress);
    }

    @Override
    protected void onPostExecute(Result result) {
        if (onPostExecute == null) return;
        onPostExecute(result);
    }

    public LambdaAsyncTask<Params, Progress, Result> doInBackground(Funcs1<Params, Result> doInBackground) {
        this.doInBackground = doInBackground;
        return this;
    }

    public LambdaAsyncTask<Params, Progress, Result> onProgressUpdate(Actions1<Progress> onProgressUpdate) {
        this.onProgressUpdate = onProgressUpdate;
        return this;
    }

    public LambdaAsyncTask<Params, Progress, Result> onPostExecute(Action1<Result> onPostExecute) {
        this.onPostExecute = onPostExecute;
        return this;
    }

    @SuppressWarnings("unchecked")
    public static <Params, Progress, Result> LambdaAsyncTask on(Funcs1<Params, Result> doInBackground) {
        return new LambdaAsyncTask<Params, Progress, Result>().doInBackground(doInBackground);
    }

    @SuppressWarnings("unchecked")
    public static <Params, Progress, Result> LambdaAsyncTask on(Funcs1<Params, Result> doInBackground, Actions1<Progress> onProgressUpdate) {
        return new LambdaAsyncTask<Params, Progress, Result>().doInBackground(doInBackground)
            .onProgressUpdate(onProgressUpdate);
    }

    @SuppressWarnings("unchecked")
    public static <Params, Progress, Result> LambdaAsyncTask on(Funcs1<Params, Result> doInBackground, Actions1<Progress> onProgressUpdate, Action1<Result> onPostExecute) {
        return new LambdaAsyncTask<Params, Progress, Result>().doInBackground(doInBackground)
            .onProgressUpdate(onProgressUpdate)
            .onPostExecute(onPostExecute);
    }

    Funcs1<Params, Result> doInBackground;
    Actions1<Progress> onProgressUpdate;
    Action1<Result> onPostExecute;

    /*
    Params[] params;

    public LambdaAsyncTask<Params, ?, ?> params(Params... params) {
        this.params = params;
        return this;
    }

    public static <T> LambdaAsyncTask<T, ?, ?> of(T... t) {
        return new LambdaAsyncTask<T, Object, Object>().params(t);
    }
    */

    /*
    public static <T, P, R> LambdaAsyncTask<T, P, R> of(Funcs1<? extends T, ? extends R> doInBackground, Actions1<? extends P> onProgressUpdate, Action1<? extends R> onPostExecute) {
        return LambdaAsyncTask.<T, P, R>on(doInBackground, onProgressUpdate, onPostExecute);
    }
    */

    //T[] params;
    //Funcs1<Params, Result> doInBackground;
    //Actions1<Progress> onProgressUpdate;
    //Action1<Result> onPostExecute;

    public interface Action1<T> {
        void call(T t);
    }

    public interface Actions1<T> {
        void call(T... t);
    }

    public interface Func0<R> {
        R call();
    }

    public interface Func1<T, R> {
        R call(T t);
    }

    public interface Funcs1<T, R> {
        R call(T... t);
    }
}
