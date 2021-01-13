package xdatastructures.stacks;

import java.util.*;

public class VisitRooms {
    public static void main(String[] args){
        List<List<Integer>> rooms = new LinkedList<>();
        rooms.add(0, Arrays.asList(1));
        rooms.add(1, Arrays.asList(2));
        rooms.add(2, Arrays.asList(3));
        rooms.add(3, Arrays.asList());
        System.out.println(new VisitRooms().canVisitAllRooms(rooms));

        List<List<Integer>> rooms2 = new LinkedList<>();
        rooms2.add(0, Arrays.asList(1,3));
        rooms2.add(1, Arrays.asList(3,0,1));
        rooms2.add(2, Arrays.asList(2));
        rooms2.add(3, Arrays.asList(0));
        System.out.println(new VisitRooms().canVisitAllRooms(rooms2));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visitRoom(0, rooms, visited);
        return visited.size()==rooms.size();
    }

    private void visitRoom(Integer currentRoom, List<List<Integer>> rooms, Set<Integer> visitedRooms){
        if(visitedRooms.size()==rooms.size() || visitedRooms.contains(currentRoom))
            return;
        visitedRooms.add(currentRoom);
        for(Integer room : rooms.get(currentRoom)){
            visitRoom(room, rooms, visitedRooms);
        }
    }

}
