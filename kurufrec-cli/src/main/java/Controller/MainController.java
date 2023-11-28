package Controller;

import Model.DataAccess.Folder.MyFolder;
import Model.Entities.LexiconEntities.JpCharacter.JpCharacterToken;
import Model.Error.ErrorType;
import Model.Error.KuruException;
import Model.Lexicon.JapaneseLexicon.JpKuroFrecuencier.JpFrecuencier;
import com.sun.tools.javac.Main;
import org.apache.commons.cli.*;
import view.CmdView;

import javax.management.MalformedObjectNameException;
import java.io.File;
import java.util.List;
import java.util.Objects;

public class MainController {



    private String[] args;
    public MainController(String[] args){
        this.args = args;
    }

    public void start(){
            parseArguments();
    }

    private void parseArguments(){
        Options opts = getOptions();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try{
            if(this.args.length == 0) throw new ParseException("Error: Nothing passed.");
            cmd = parser.parse(opts, this.args);
            File inputFile = new File(cmd.getOptionValue("in"));
            File outputFile = new File(cmd.getOptionValue("out"));
            String type = cmd.getOptionValue("t");
            processInput(inputFile, outputFile, type);
        }catch (ParseException e){
            HelpFormatter helpFormatter = new HelpFormatter();
            helpFormatter.printHelp("help", opts);
            System.exit(0);
        }

    }

    private void processInput(File input, File output, String type){
        try {
            CmdView.reportInfo("Preparing...");
            CmdView.reportInfo("Verifying the input given...");
            checkIfExists(input);
            checkifAbsolute(input, output);
            checkTypeOperation(type);
            CmdView.reportInfo("Starting the process...");
            if(type.equalsIgnoreCase("k")){
                doKanjiFrecuency(input,output);
            }else {
                doWordFrecuency(input, output);
            }
        }catch (KuruException e){
            CmdView.ReportError(e.getMessage(), e.getTypeError());
        }
    }

    private void doKanjiFrecuency(File input, File output){
            CmdView.reportInfo("Starting frecuency processs of kanjis.");
            JpFrecuencier frecuencier = new JpFrecuencier(input);
            String result = frecuencier.getFrecuencyKanjiListAsString();
            CmdView.reportInfo("Frecuency of kanji done.");
            MyFolder.writeOnFile(result, output);
            CmdView.reportInfo("Saved to: "+output.toString());
    }

    private void doWordFrecuency(File input, File output){
        CmdView.reportInfo("Starting japanese word process...");
        JpFrecuencier frecuencier = new JpFrecuencier(input);
        String result = frecuencier.getFrecuencyWordListAsString();
        CmdView.reportInfo("Frecuency of words done.");
        MyFolder.writeOnFile(result, output);
        CmdView.reportInfo("Saved to : "+output.toString());
    }
    private void checkTypeOperation(String type){
        if(!type.equalsIgnoreCase("k") && !type.equalsIgnoreCase("w")) throw new KuruException("The type is not supported. ["+type+"]", ErrorType.EXTERNAL);
    }

    private void  checkIfExists(File input){
        if(Objects.isNull(input)) throw new KuruException("The input file is null", ErrorType.INTERNAL);
        if(!input.exists()) throw new KuruException("The input file doesn't exists", ErrorType.EXTERNAL);
    }

    private void checkifAbsolute(File input, File output){
        if(!input.isAbsolute()) throw new KuruException("The input path must be absolute", ErrorType.EXTERNAL);
        if(!output.isAbsolute()) throw new KuruException("the output path must be absolute", ErrorType.EXTERNAL);
    }

    private Options getOptions(){
        Option  inputSource =  Option.builder("in").longOpt("input").desc("Input of the japanese text").hasArg(true).required(true).build();
        Option typeOp = Option.builder("t").longOpt("type").hasArg(true).desc("").required(true).build();
        Option outputResult = Option.builder("out").longOpt("output").hasArg(true).desc("output of the final frecuency file.").required(true).build();
        Options options = new Options();
        options.addOption(inputSource).addOption(typeOp).addOption(outputResult);
        return options;
    }



}
