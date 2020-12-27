package coding.other;

import java.text.SimpleDateFormat;
import java.util.*;

class ShowTime2 {

    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            runTest();
        }
    }

    private static void runTest() throws  Exception{
        int n = sc.nextInt();
        List<ShowTime> freeSlots = new ArrayList<ShowTime>();
        freeSlots.add(new ShowTime(000000, 240000));
        while( n > 0 ){
            ShowTime showTime = buildShowTime();
            updateFreeSlot(showTime, freeSlots);
            n--;
        }
        displayResults(freeSlots);
    }

    private static void displayResults(List<ShowTime> freeSlots) throws Exception{
        int count = freeSlots.size();
        int totalDuration = 0;
        for(ShowTime freeTime : freeSlots){
            Date startTime = formatTime(freeTime.s);
            Date endTime = formatTime(freeTime.e);
//            totalDuration = totalDuration + (endTime - startTime);

        }
        int digitsCount = 0 ;
        int totalDurationDigits = totalDuration;
        while( totalDurationDigits / 10 > 0 ){
            totalDurationDigits = totalDurationDigits / 10;
            digitsCount++;
        }
        StringBuilder sb = new StringBuilder();
        while(digitsCount!=5){
            sb.append("0");
            digitsCount++;
        }
        sb.append(totalDuration);
        String sbStr = sb.toString();
        String timeFormat = sbStr.substring(0,2);
        timeFormat = timeFormat +":";
        if(sbStr.substring(2,4).equals("00")){
            timeFormat = timeFormat + "60";
        }else{
            timeFormat = timeFormat + sbStr.substring(2,4);
        }
        timeFormat = timeFormat +":";
        if(sbStr.substring(4).equals("00")){
            timeFormat = timeFormat + "60";
        }else{
            timeFormat = timeFormat + sbStr.substring(2,4);
        }
        System.out.println(count + " " + timeFormat);
    }

    private static Date formatTime(int time) throws Exception{
        int digitsCount = 0 ;
        int totalDurationDigits = time;
        while( totalDurationDigits / 10 > 0 ){
            totalDurationDigits = totalDurationDigits / 10;
            digitsCount++;
        }
        StringBuilder sb = new StringBuilder();
        while(digitsCount!=5){
            sb.append("0");
            digitsCount++;
        }
        sb.append(time);
        String sbStr = sb.toString();
        String timeFormat = sbStr.substring(0,2) + ":" + sbStr.substring(2,4) + ":" + sbStr.substring(2,4);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.parse(timeFormat);
    }


    private static void updateFreeSlot(ShowTime showTime, List<ShowTime> freeSlots){
        boolean showAdded = false;
        boolean addShow = false;
        List<Integer> splitIndexes = new ArrayList<Integer>();
        for(int i = 0 ; i < freeSlots.size() ; i++){
            ShowTime freeTime = freeSlots.get(i);
            if(showTime.s < freeTime.e && showTime.e > freeTime.s){
                addShow = true;
                splitIndexes.add(i);
            }
        }
        int incrementedCount = 0;
        for(int splitIndex : splitIndexes){
            int updatedIndex = incrementedCount + splitIndex;
            ShowTime freeTime = freeSlots.get(updatedIndex);
            freeSlots.remove(updatedIndex);
            List<ShowTime> newFreeTime = splitTime(showTime, freeTime);
            if(!newFreeTime.isEmpty()){
                for(ShowTime time : newFreeTime){
                    freeSlots.add(updatedIndex, time);
                    updatedIndex++;

                }
                incrementedCount = incrementedCount + newFreeTime.size();
            }
        }
    }

    private static List<ShowTime> splitTime(ShowTime showTime, ShowTime freeTime){
        List<ShowTime> freeSlotsNew = new ArrayList<ShowTime>();
        if( showTime.s > freeTime.s ){
            freeSlotsNew.add(new ShowTime(freeTime.s, showTime.s));
        }
        if( showTime.e < freeTime.e ){
            freeSlotsNew.add(new ShowTime(showTime.e, freeTime.e));
        }
        return freeSlotsNew;
    }

    private static ShowTime buildShowTime(){
        return new ShowTime(getShowTime(sc.next()), getShowTime(sc.next()));
    }

    private static int getShowTime(String show){
        return Integer.valueOf(show.replaceAll(":",""));
    }

    static class ShowTime{
        int s;
        int e;
        ShowTime(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
}

