package com.example.lotto;

import java.util.ArrayList;

public class LottoTicket {

    private int maxValue;

    private ArrayList<Integer> numbers;

    public LottoTicket(int numberOfValues, int maxValue){
        numbers = new ArrayList<>();
        this.maxValue = maxValue;

        for ( int number = 0; number < numberOfValues; number++){
            numbers.add((int)(Math.random() * maxValue) + 1);
        }

    }

    public boolean isWinner(LottoTicket winningTicket){
        if ( maxValue != winningTicket.getMaxValue() || numbers.size() != winningTicket.getNumbers().size() ){
            return false;
        }

        for ( int index = 0; index < numbers.size(); index++){
            if ( numbers.get(index) != winningTicket.getNumbers().get(index)){
                return false;
            }
        }

        return true;
    }

    public int getMaxValue() {
        return maxValue;
    }

    // it's risky to return the array list direct, because the contents can be modified
    public ArrayList<Integer> getNumbers() {
        return (ArrayList<Integer>) numbers.clone();
    }
}
