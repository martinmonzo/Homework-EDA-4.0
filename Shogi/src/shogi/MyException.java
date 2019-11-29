/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shogi;

/**
 *
 * @author 54261
 */
public class MyException extends Exception {
    private final String message;

    public MyException(String message){
        this.message = message;
    }
    
    // Overrides Exception's getMessage()
    @Override
    public String getMessage(){
        return message;
    }
}
