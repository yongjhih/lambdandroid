package android.os;

public class LambdaAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
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

    public LambdaAsyncTask doInBackground(Funcs1<Params, Result> doInBackground) {
        this.doInBackground = doInBackground;
        return this;
    }

    public LambdaAsyncTask onProgressUpdate(Actions1<Progress> onProgressUpdate) {
        this.onProgressUpdate = onProgressUpdate;
        return this;
    }

    public LambdaAsyncTask onPostExecute(Action1<Result> onPostExecute) {
        this.onPostExecute = onPostExecute;
        return this;
    }

    Funcs1<Params, Result> doInBackground;
    Actions1<Progress> onProgressUpdate;
    Action1<Result> onPostExecute;

    public interface Action1<T> {
        void call(T t);
    }

    public interface Actions1<T> {
        void call(T... t);
    }

    public interface Func1<T, R> {
        R call(T t);
    }

    public interface Funcs1<T, R> {
        R call(T... t);
    }
}
