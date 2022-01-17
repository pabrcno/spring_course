package com.github.pabrcno.be_project.domain.core.Observer;

public interface ISubject {

    void registerObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers();

}