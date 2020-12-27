package battleships;

class ConstraintFailedException extends Exception{

    public ConstraintFailedException(String message){
        super(message);
    }
}