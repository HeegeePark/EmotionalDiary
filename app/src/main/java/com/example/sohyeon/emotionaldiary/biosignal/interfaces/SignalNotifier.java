package com.example.sohyeon.emotionaldiary.biosignal.interfaces;


public interface SignalNotifier {
    public void didReadPpg(int ppg);
    public void didReadHrv(double[] hrv);
}
