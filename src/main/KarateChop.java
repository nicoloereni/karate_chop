package main;

import java.util.ArrayList;
import java.util.List;

import static main.ArrayUtil.*;
import static main.KarateChop.NOT_FOUND_VALUE;

public class KarateChop {

    public static final int NOT_FOUND_VALUE = -1;


    private List<ChopHandler> chopHandlers;

    public KarateChop() {
        this.chopHandlers = new ArrayList();

        chopHandlers.add(new OnTheRightHandler());
        chopHandlers.add(new OnTheLeftHandler());
        chopHandlers.add(new OnTheMiddleHandler());
    }

    public Integer chop(Integer valueToFind, Integer[] sortedArray) {
        Integer result = NOT_FOUND_VALUE;

        for(ChopHandler chopHandler : chopHandlers){
            if(chopHandler.canHandle(valueToFind, sortedArray)){
                result = chopHandler.findPosition(valueToFind, sortedArray, this);
            }
        }

        return result;
    }

}

interface ChopHandler {

    Boolean canHandle(Integer valueToFind, Integer[] sortedArray);

    Integer findPosition(Integer valueToFind, Integer[] sortedArray, KarateChop karateChop);

}

class OnTheRightHandler implements ChopHandler {

    @Override
    public Boolean canHandle(Integer valueToFind, Integer[] sortedArray) {
        return isValueOnTheRight(valueToFind, sortedArray);
    }

    @Override
    public Integer findPosition(Integer valueToFind, Integer[] sortedArray, KarateChop karateChop) {
        Integer resultChopOnRight = karateChop.chop(valueToFind, splitRight(sortedArray));
        return resultChopOnRight != NOT_FOUND_VALUE ? resultChopOnRight + middlePosition(sortedArray) + 1 : NOT_FOUND_VALUE;
    }

    private Integer[] splitRight(Integer[] sortedArray) {
        Integer[] result = new Integer[sortedArray.length - (middlePosition(sortedArray) + 1)];
        System.arraycopy(sortedArray, middlePosition(sortedArray) + 1, result, 0, result.length);
        return result;
    }


    private Boolean isValueOnTheRight(Integer valueToFind, Integer[] sortedArray) {
        return !isEmpty(sortedArray) && !isLastElement(sortedArray) && valueToFind.compareTo(middleValue(sortedArray)) > 0;
    }
}

class OnTheLeftHandler implements ChopHandler {

    @Override
    public Boolean canHandle(Integer valueToFind, Integer[] sortedArray) {
        return isValueOnTheLeft(valueToFind, sortedArray);
    }

    @Override
    public Integer findPosition(Integer valueToFind, Integer[] sortedArray, KarateChop karateChop) {
        return karateChop.chop(valueToFind, splitLeft(sortedArray));
    }

    private Boolean isValueOnTheLeft(Integer valueToFind, Integer[] sortedArray) {
        return !isEmpty(sortedArray) && !isLastElement(sortedArray) && valueToFind.compareTo(middleValue(sortedArray)) < 0;
    }

    private Integer[] splitLeft(Integer[] sortedArray) {
        Integer[] result = new Integer[middlePosition(sortedArray)];
        System.arraycopy(sortedArray, 0, result, 0, middlePosition(sortedArray));
        return result;
    }
}

class OnTheMiddleHandler implements ChopHandler {

    @Override
    public Boolean canHandle(Integer valueToFind, Integer[] sortedArray) {
        return isValueOnTheMiddle(valueToFind, sortedArray);
    }

    @Override
    public Integer findPosition(Integer valueToFind, Integer[] sortedArray, KarateChop karateChop) {
        return middlePosition(sortedArray);
    }

    private Boolean isValueOnTheMiddle(Integer valueToFind, Integer[] sortedArray) {
        return !isEmpty(sortedArray) &&
                valueToFind.equals(middleValue(sortedArray));
    }
}

class ArrayUtil {

    public static Boolean isEmpty(Integer[] sortedArray) {
        return Integer.valueOf("0").equals(sortedArray.length);
    }

    public static Integer middleValue(Integer[] sortedArray) {
        return sortedArray[middlePosition(sortedArray)];
    }

    public static Integer middlePosition(Integer[] sortedArray) {
        return sortedArray.length / 2;
    }

    public static Boolean isLastElement(Integer[] sortedArray) {
        return sortedArray.length == 1;
    }

}
