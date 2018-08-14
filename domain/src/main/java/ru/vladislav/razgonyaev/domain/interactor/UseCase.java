package ru.vladislav.razgonyaev.domain.interactor;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T, P> {

    private CompositeDisposable disposable;

    public UseCase() {
        disposable = new CompositeDisposable();
    }

    public abstract Single<T> run(P params);

    public void execute(DisposableSingleObserver<T> singleObserver, P params) {
        disposable.add(run(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(singleObserver)
        );
    }

    public void dispose() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
