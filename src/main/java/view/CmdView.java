package view;

import Model.Error.ErrorType;
import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class CmdView {

    public static void reportInfo(String info){
        System.out.println(colorize("[INFO]", Attribute.BLUE_TEXT()) + colorize(": "+info, Attribute.GREEN_TEXT()));
    }
    public static void ReportError(String error, ErrorType type){
        if(type.equals(ErrorType.INTERNAL)){
            System.out.println(colorize("[INTERNAL ERROR]: "+error, Attribute.RED_TEXT()));
        }else{
            System.out.println(colorize("[EXTERNAL ERROR]: "+error, Attribute.RED_TEXT()));
        }

    }

}
