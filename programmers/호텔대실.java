package programmers;

import java.util.*;

public class 호텔대실 {

    class Solution {

        class Time implements Comparable<Time> {
            int start;
            int end;
            Time(int start, int end){
                this.start = start;
                this.end = end;
            }

            @Override
            public int compareTo(Time time){
                if(time.start < start ){
                    return 1;
                }
                else if(time.start > start){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }

        class RoomTime implements Comparable<RoomTime> {
            int time;
            RoomTime(int time){
                this.time = time;
            }

            @Override
            public int compareTo(RoomTime rt){
                if(rt.time < time ){
                    return 1;
                }
                else if(rt.time > time){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }

        public int solution(String[][] book_time) {

            ArrayList<Time> reservations = new ArrayList<>();

            for(String[] strArr : book_time){
                reservations.add(parsing(strArr[0], strArr[1]));
            }

            Collections.sort(reservations);
            ArrayList<RoomTime> room = new ArrayList<>();

            // 필요한 방 개수 세기
            for(Time time : reservations){

                Collections.sort(room);

                boolean flag = false;

                for(int i = 0 ; i < room.size() ; i++){

                    if(room.get(i).time <= time.start){
                        room.set(i, new RoomTime(time.end));
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    room.add(new RoomTime(time.end));
                }

            }


            return room.size();
        }

        private Time parsing(String timeStart, String timeEnd){
            String startList = timeStart.replace(":","");
            String endList = timeEnd.replace(":","");

            int endTime = Integer.parseInt(endList);
            endTime += 10;
            if(endTime % 100 >= 60){
                endTime -= 60;
                endTime += 100;
            }

            return new Time(Integer.parseInt(startList), endTime);
        }
    }
}
