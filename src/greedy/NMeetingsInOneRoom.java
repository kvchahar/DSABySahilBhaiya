package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Meeting {
    int start;
    int end;
    int pos;

    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<Meeting> {

    @Override
    public int compare(Meeting o1, Meeting o2) {

        if (o1.end < o2.end) {
            return -1;
        } else if (o1.end > o2.end) {
            return 1;
        } else if (o1.pos < o2.pos) {
            return -1;
        }
        return 1;
    }
}

public class NMeetingsInOneRoom {
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public int maxMeetings(int[] start, int[] end, int n) {
        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        MeetingComparator meetComp = new MeetingComparator();
        Collections.sort(meetings, meetComp);

        ArrayList<Integer> result = new ArrayList<>();
        int limit = meetings.get(0).end;
        result.add(meetings.get(0).pos);
        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > limit) {
                limit = meetings.get(i).end;
                result.add(meetings.get(i).pos);
            }
        }

        // for(int i = 0; i<result.size(); i++){
        //     System.out.print(result.get(i) + " ");
        // }

        return result.size();
    }

    public static void main(String[] args) {
        int N = 6;
        int[] start = {1,3,0,5,8,5};
        int[] end =  {2,4,6,7,9,9};
         NMeetingsInOneRoom meet = new NMeetingsInOneRoom();
         int ans = meet.maxMeetings(start,end,N);
        System.out.println(ans);
    }
}
