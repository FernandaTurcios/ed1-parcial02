package ed.lab;

import java.util.List;
import java.util.PriorityQueue;

public class E01MeetingRooms {

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.isEmpty()) {
            return 0;
        }

        meetingIntervals.sort((a, b) -> Integer.compare(a.startTime(), b.startTime()));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (MeetingInterval interval : meetingIntervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.startTime()) {
                minHeap.poll();
            }

            minHeap.offer(interval.endTime());
        }

        return minHeap.size();
    }
}

//cola de prioridad, es como de descarte