package android.animation;

public class Animators {
    private Animators() {
    }

    // AnimatorListenerAdapter/SimpleAnimatorListener
    public static class AnimatorListener implements Animator.AnimatorListener {
        @Override
        public void onAnimationCancel(Animator animation) {
            if (onAnimationCancel == null) return;
            onAnimationCancel.call(animation);
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            if (onAnimationEnd == null) return;
            onAnimationEnd.call(animation);
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            if (onAnimationRepeat == null) return;
            onAnimationRepeat.call(animation);
        }

        @Override
        public void onAnimationStart(Animator animation) {
            if (onAnimationStart == null) return;
            onAnimationStart.call(animation);
        }

        Action1<Animator> onAnimationCancel;
        Action1<Animator> onAnimationEnd;
        Action1<Animator> onAnimationRepeat;
        Action1<Animator> onAnimationStart;

        public AnimatorListener cancel(Action1<Animator> onAnimationCancel) {
            this.onAnimationCancel = onAnimationCancel;
            return this;
        }

        public AnimatorListener end(Action1<Animator> onAnimationEnd) {
            this.onAnimationEnd = onAnimationEnd;
            return this;
        }

        public AnimatorListener repeat(Action1<Animator> onAnimationRepeat) {
            this.onAnimationRepeat = onAnimationRepeat;
            return this;
        }

        public AnimatorListener start(Action1<Animator> onAnimationStart) {
            this.onAnimationStart = onAnimationStart;
            return this;
        }

        public static AnimatorListener on(Action1<Animator> onAnimationCancel, Action1<Animator> onAnimationEnd, Action1<Animator> onAnimationRepeat, Action1<Animator> onAnimationStart) {
            return new AnimatorListener().cancel(onAnimationCancel).end(onAnimationEnd).repeat(onAnimationRepeat).start(onAnimationStart);
        }
    }

    interface Action1<T> {
        void call(T t);
    }
}
