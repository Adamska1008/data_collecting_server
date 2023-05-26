package com.web_programming.data_collecting_server.device;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//呼吸机
public class Breathing {
    private int respiratoryRate;// 呼吸频率--次/min--16-30
    private int tidalVolume;// 潮气量--mL/kg--6-15
    private int oxygenConcentration;// 氧浓度--%--0-50

    public Map<String,String> randomData(){
        Map<String, String> map = new HashMap<>();
        // 数据，10个随机一个
//    int rate[]={18,20,22,23,24,26,28,30,35,38};
//    int chao[]={4,7,8,9,10,11,12,13,14,18};
//    int oxygen[]={15,20,25,30,33,35,40,45,55,60};
        Random random = new Random();
        int r1=random.nextInt(20)+16;
        int r2=random.nextInt(12)+6;
        int r3= random.nextInt( 55);
        map.put("呼吸频率",String.valueOf(r1));
        map.put("潮气量",String.valueOf(r2));
        map.put("氧浓度",String.valueOf(r3));
        return map;
    }

    public Breathing( ) {
    }

    public Breathing(int respiratoryRate, int tidalVolume,
                     int oxygenConcentration) {
        this.respiratoryRate = respiratoryRate;
        this.tidalVolume = tidalVolume;
        this.oxygenConcentration = oxygenConcentration;
    }

    public int getRespiratoryRate( ) {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getTidalVolume( ) {
        return tidalVolume;
    }

    public void setTidalVolume(int tidalVolume) {
        this.tidalVolume = tidalVolume;
    }

    public int getOxygenConcentration( ) {
        return oxygenConcentration;
    }

    public void setOxygenConcentration(int oxygenConcentration) {
        this.oxygenConcentration = oxygenConcentration;
    }

    @Override
    public String toString( ) {
        return "Breathing{" +
                "respiratoryRate=" + respiratoryRate +
                ", tidalVolume=" + tidalVolume +
                ", oxygenConcentration=" + oxygenConcentration +
                '}';
    }
}
