package android.support.v4.view;

public class ViewPagers {
    private ViewPagers() {
    }

    public static class OnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int state) {
            if (onPageScrollStateChanged == null) return;
            onPageScrollStateChanged.call(state);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (onPageScrolled == null) return;
            onPageScrolled.call(position, positionOffset, positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            if (onPageSelected == null) return;
            onPageSelected.call(position);
        }

        Action1<Integer> onPageScrollStateChanged;
        Action3<Integer, Float, Integer> onPageScrolled;
        Action1<Integer> onPageSelected;

        public OnPageChangeListener onPageScrollStateChanged(Action1<Integer> onPageScrollStateChanged) {
            this.onPageScrollStateChanged = onPageScrollStateChanged;
            return this;
        }

        public OnPageChangeListener onPageScrolled(Action3<Integer, Float, Integer> onPageScrolled) {
            this.onPageScrolled = onPageScrolled;
            return this;
        }

        public OnPageChangeListener onPageSelected(Action1<Integer> onPageSelected) {
            this.onPageSelected = onPageSelected;
            return this;
        }

        public static OnPageChangeListener onPageChange(Action1<Integer> onPageSelected) {
            return new OnPageChangeListener().onPageSelected(onPageSelected);
        }

        public static OnPageChangeListener onPageChange(Action1<Integer> onPageSelected, Action1<Integer> onPageScrollStateChanged) {
            return new OnPageChangeListener().onPageSelected(onPageSelected).onPageScrollStateChanged(onPageScrollStateChanged);
        }

        public static OnPageChangeListener onPageChange(Action1<Integer> onPageSelected, Action1<Integer> onPageScrollStateChanged, Action3<Integer, Float, Integer> onPageScrolled) {
            return new OnPageChangeListener().onPageSelected(onPageSelected).onPageScrollStateChanged(onPageScrollStateChanged).onPageScrolled(onPageScrolled);
        }
    }

    interface Action1<T> {
        void call(T t);
    }

    interface Action3<T, T2, T3> {
        void call(T t, T2 t2, T3 t3);
    }
}
