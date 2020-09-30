import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class BasicLanguageCore {

    public static void main(String[] args){
        String str = "END"; //todo Enjoy your coding here!
        DefaultInteractBlock dib = new DefaultInteractBlock();
        TBekoCore tbc = new TBekoCore(str, dib);
        tbc.read();
    }

    public static class TBekoCore {
        public static final String HH_TAG = "@[TBEKO_HH]";

        private boolean isStart = false;

        private String src = "";
        private IInteractBlock iib;

        private Map<String, TObject> objectMap = new HashMap<>();
        private int readLine = -1;
        private int maxReadLine = -1;

        public TBekoCore(String src, IInteractBlock iib) {
            if (src != null)
                this.src = src;
            this.iib = iib;
        }

        public void read() {
            this.src = this.src.replace("\r", HH_TAG).replace("\n", HH_TAG).replace(HH_TAG + HH_TAG, HH_TAG);
            this.src = this.src.replace(HH_TAG, "\n");
            this.src = this.src.trim();

            isStart = true;

            String[] srcArray = this.src.split("\n");
            for (readLine = 0; readLine < srcArray.length; readLine++) {
                readLine(srcArray[readLine]);
            }
        }

        public void readLine(String str) {
            while (str.length() != 0 && str.charAt(0) == ' ') str = str.replaceFirst(" ", "");
            String[] cmd = str.split(" ");
            if (cmd.length <= 0) return;

            boolean isStringCatching = false;
            char[] strCharArray = str.toCharArray();
            String tempStr = "";
            int lastStringCharLoc = -1, k = 0;

            for (int i = 0; i < strCharArray.length; i++) {
                char c = strCharArray[i];
                if (c == '\"') {
                    if (isStringCatching) {
                        isStringCatching = false;
                        String oName = "!@#$%^%_" + k;
                        this.putObject(oName, new TStringObject(tempStr.substring(1, tempStr.length())));
                        str = new StringBuilder(str).insert(lastStringCharLoc, oName).toString();
                        lastStringCharLoc = -1;

                        i += oName.length();

                        StringBuffer sb = new StringBuffer(str);
                        sb.setCharAt(i, ' ');
                        str = sb.toString();
                    } else {
                        isStringCatching = true;
                        lastStringCharLoc = i;
                        k++;
                        StringBuffer sb = new StringBuffer(str);
                        sb.setCharAt(i, ' ');
                        str = sb.toString();
                    }
                }
                if (isStringCatching) {
                    tempStr += c;
                    StringBuffer sb = new StringBuffer(str);
                    sb.setCharAt(i, ' ');
                    str = sb.toString();
                }
            }

            if (isStringCatching) {
                return;
            }

            String arg = str.replaceFirst(cmd[0], "");
            while (arg.length() != 0 && arg.charAt(0) == ' ') arg = arg.replaceFirst(" ", "");
            if(arg.replace(" ","").length()==0) arg=str.replace(" ","");

            switch (cmd[0].toUpperCase()) {
                default:
                    if(arg.contains("=")) {
                        new SetStatement(this, arg.trim()).run();
                    }
                    return;
                case "PRINT":
                    new PrintStatement(this, arg.trim()).run();
                    return;
                case "DISP":
                    new PrintStatement(this, arg.trim()).run();
                    return;
                case "INPUT":
                    new InputStatement(this, arg.trim()).run();
                    return;
                case "SET":
                    new SetStatement(this,arg.trim()).run();
                    return;
                case "IF":
                    new IfFunction(this, arg.trim()).run();
                    return;
                case "WHILE":
                    new WhileStatement(this,arg.trim()).run();
                    return;
                case "DO":
                    new DoStatement(this,arg.trim()).run();
                    return;
                case "END":
                    return;
                case "LOOP":
                    return;
                case "WEND":
                    return;
            }
        }

        public String getSourceCode() {
            return src;
        }

        public Map<String, TObject> getObjectMap() {
            return objectMap;
        }

        public String counterString(String str) {
            str = this.replaceObjectName(str);
            if (this.isMathStatement(str)) {
                if ((this.mathCount(str) + "").equalsIgnoreCase(Double.NaN + "")) {
                    String backStr_1 = this.replaceObjectName(str);
                    if (backStr_1.contains("\"")) {
                        if (this.isMathStatement(backStr_1.replace("+", ""))) {
                            return str;
                        } else {
                            String[] args = backStr_1.replace("+", "\n").split("\n");
                            List<String> stringList = new ArrayList<>();
                            for (String stringStr : args) {
                                boolean isStart = false;
                                int startLoc = -1;
                                char[] strArray = new char[stringStr.length() + 50];
                                for (int i = 0; i < stringStr.length(); i++) {
                                    if (stringStr.charAt(i) == '\"') {
                                        if (!isStart) {
                                            isStart = true;
                                            continue;
                                        } else {
                                            isStart = false;
                                            break;
                                        }
                                    } else {
                                        strArray[i - startLoc] = stringStr.charAt(i);
                                    }
                                }
                                String string = new String(strArray);
                                stringList.add(string);
                            }
                            String endStringStr = "";
                            for (String s : stringList) endStringStr += s;
                            return endStringStr;
                        }
                    } else {
                        if ((this.mathCount(backStr_1) + "").equalsIgnoreCase(Double.NaN + "")) {
                            return str;
                        } else {
                            return this.mathCount(backStr_1) + "";
                        }
                    }
                } else {
                    return this.mathCount(str) + "";
                }
            } else {
                return replaceObjectName(str);
            }
        }

        public String replaceObjectName(String str) {
            return this.replaceObjectName(str, false);
        }

        public String replaceObjectName(String str, boolean b) {
            List<String> objectNameList = new ArrayList<>();
            for (Object o : Arrays.asList(this.objectMap.keySet().toArray())) objectNameList.add(o.toString());

            Collections.sort(objectNameList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return 0;
                }
            });

            if (b)
                str = str.replace("+", " + ").replace("-", " - ").replace("*", " * ").replace("/", " / ").replace("\\", " \\ ").replace("%", " % ");

            for (String objectName : objectNameList) {
                if (str.contains(objectName.toString().trim())) {
                    if (b && !str.contains(" " + objectName.toString().trim() + " ")) {
                        continue;
                    }
                    TObject to = this.objectMap.get(objectName);
                    if (to.getType() == TObjectType.Number) {
                        str = str.replace(objectName, this.objectMap.get(objectName).toString() + "");
                    } else if (to.getType() == TObjectType.String) {
                        str = str.replace(objectName, "\"" + this.objectMap.get(objectName).toString() + "\"");
                    } else {
                        continue;
                    }
                }
            }
            return str;
        }

        public double mathCount(String str) {
            return Calculator.conversion(str.replace(" ", ""));
        }

        public boolean isMathStatement(String str) {
            return Calculator.isHaveOperator(str);
        }

        public IInteractBlock getInteractBlock() {
            return iib;
        }

        public void getInteractBlock(IInteractBlock iib) {
            this.iib = iib;
        }

        public void putObject(String name, TObject value) {
            name = name.toUpperCase();
            if (value != null)
                this.objectMap.put(name, value);
            else
                this.objectMap.remove(name);
        }

        public String getLineCode(int i) {
            if (!this.isStart) return null;
            String[] srcArray = this.src.split("\n");
            if (srcArray.length < i || i < 0) return null;
            return srcArray[i];
        }

        public int getLineNum() {
            return this.readLine;
        }

        public void moveLineNum(int readLine) {
            this.readLine = readLine;
        }

        public int getMaxLineNum() {
            if (!isStart) return -233;

            if (this.maxReadLine < 0)
                this.maxReadLine = src.split("\n").length - 1;

            return maxReadLine;
        }

        @Deprecated
        public void stop() {
            System.exit(0);
        }
    }

    public static class DoStatement extends Statement {
        public DoStatement(TBekoCore tbc, String arg) {
            super(tbc, arg);
        }

        @Override
        public void run() {
            int LOOP_line_num=-1;
            for(int i=this.getTBekoCore().getLineNum()+1;i<=this.getTBekoCore().getMaxLineNum();i++){
                if(this.getTBekoCore().getLineCode(i).trim().replace(" ","").contains("LOOPUNTIL")){
                    LOOP_line_num = i;
                }
            }

            if(LOOP_line_num==-1){
                this.getTBekoCore().getInteractBlock().outError("DO Statement Cannot Find a correct LOOP Statement to correct.",this.getTBekoCore());
                return;
            }

            String[] loop_args = this.getTBekoCore().getLineCode(LOOP_line_num).trim().split(" ");
            if(loop_args.length<3 || !loop_args[1].contains("UNTIL")){
                this.getTBekoCore().getInteractBlock().outError("DO Statement Cannot Find a correct LOOP Statement With UNTIL to correct.",this.getTBekoCore());
                return;
            }

            String pdStr = this.getTBekoCore().getLineCode(LOOP_line_num).replaceAll("LOOP UNTIL ","").replace(" ","");

            RelationOperator ro = IfFunction.getRelation(pdStr);
            String[] strArray = IfFunction.getRelationArray(pdStr);
            if (strArray.length != 2) {
                this.getTBekoCore().getInteractBlock().outError("Wrong Relation Equation",this.getTBekoCore());
                return;
            }

            for(int i=this.getTBekoCore().getLineNum()+1;i<LOOP_line_num;i++){
                this.getTBekoCore().readLine(this.getTBekoCore().getLineCode(i));
            }

            while(isRun(ro,strArray)){
                for(int i=this.getTBekoCore().getLineNum()+1;i<LOOP_line_num;i++){
                    this.getTBekoCore().readLine(this.getTBekoCore().getLineCode(i));
                }
            }

            this.getTBekoCore().moveLineNum(LOOP_line_num+1);
        }

        private boolean isRun(RelationOperator ro,String[] strArray){
            boolean isRun = false;
            if (IfFunction.isCorrectPrerequisite(this.getTBekoCore().counterString(strArray[0]),this.getTBekoCore().counterString(strArray[1]),ro))
                isRun = true;
            return !isRun;
        }
    }

    public enum RelationOperator {
        LT,
        LE,
        GT,
        GE,
        EQ,
        NE
    }

    public static class IfFunction extends Statement {

        public IfFunction(TBekoCore tbc, String arg) {
            super(tbc, arg);
        }

        @Override
        public void run() {
            if (this.getArg().toUpperCase().split("THEN").length == 1) {
                String[] argArray = this.getArg().split("THEN");
                String pdStr = argArray[0].trim().replace(" ", "");

                RelationOperator ro = this.getRelation(pdStr);
                String[] strArray = this.getRelationArray(pdStr);
                if (strArray.length != 2) {
                    this.getTBekoCore().getInteractBlock().outError("Wrong Relation Equation",this.getTBekoCore());
                    return;
                }

                boolean isRun = false;
                if (this.isCorrectPrerequisite(this.getTBekoCore().counterString(strArray[0]),this.getTBekoCore().counterString(strArray[1]),ro))
                    isRun = true;

                if (isRun) {
                    int nowLine = this.getTBekoCore().getLineNum();
                    boolean isRead = true;
                    for (int i = nowLine + 1; i <= this.getTBekoCore().getMaxLineNum(); i++) {
                        String str = this.getTBekoCore().getLineCode(i);
                        while (str.length() != 0 && str.charAt(0) == ' ') str = str.replaceFirst(" ", "");
                        String[] cmd = str.split(" ");
                        if (cmd.length <= 0) continue;

                        if (cmd[0].equalsIgnoreCase("END")) {
                            if (cmd.length == 1) {
                                this.getTBekoCore().stop();
                            } else {
                                if (cmd[1].equalsIgnoreCase("IF")) {
                                    this.getTBekoCore().moveLineNum(i + 1);
                                    return;
                                }
                            }
                        } else if (cmd[0].equalsIgnoreCase("ELSE")) {
                            isRead = false;
                        }

                        if (isRead) {
                            this.getTBekoCore().readLine(str);
                            this.getTBekoCore().moveLineNum(i+1);
                        }
                    }
                }else{
                    int nowLine = this.getTBekoCore().getLineNum();

                    this.getTBekoCore().moveLineNum( this.getTBekoCore().getLineNum() + 1);

                    for (int i = nowLine + 1; i <= this.getTBekoCore().getMaxLineNum(); i++) {
                        String str = this.getTBekoCore().getLineCode(i);

                        while (str.length() != 0 && str.charAt(0) == ' ') str = str.replaceFirst(" ", "");
                        String[] cmd = str.split(" ");
                        if (cmd.length <= 0) continue;

                        if(cmd[0].equalsIgnoreCase("ELSE")){
                            this.getTBekoCore().moveLineNum(this.getTBekoCore().getLineNum()+1);
                            break;
                        }else{
                            this.getTBekoCore().moveLineNum(this.getTBekoCore().getLineNum()+1);
                        }
                    }

                    nowLine = this.getTBekoCore().getLineNum()-1;
                    for (int i = nowLine + 1; i <= this.getTBekoCore().getMaxLineNum(); i++) {
                        String str = this.getTBekoCore().getLineCode(i);

                        while (str.length() != 0 && str.charAt(0) == ' ') str = str.replaceFirst(" ", "");
                        String[] cmd = str.split(" ");
                        if (cmd.length <= 0) continue;

                        if (cmd[0].equalsIgnoreCase("END")) {
                            if (cmd.length == 1) {
                                this.getTBekoCore().stop();
                            } else if(cmd.length != 1) {
                                if (cmd[1].equalsIgnoreCase("IF")) {
                                    this.getTBekoCore().moveLineNum(i + 1);
                                    return;
                                }
                            }
                        }

                        this.getTBekoCore().readLine(str);
                        this.getTBekoCore().moveLineNum(i+1);
                    }
                }

            } else if (this.getArg().toUpperCase().split("THEN").length > 0) {
                String[] argArray = this.getArg().toUpperCase().split("THEN");
                this.getTBekoCore().readLine(argArray[1]);
            }
        }

        public static RelationOperator getRelation(String str) {
            if (str.contains("<=")) return RelationOperator.LE;
            if (str.contains(">=")) return RelationOperator.GE;
            if (str.contains("!=")) return RelationOperator.NE;
            if (str.contains("<")) return RelationOperator.LT;
            if (str.contains(">")) return RelationOperator.GT;
            if (str.contains("=")) return RelationOperator.EQ;
            return null;
        }

        public static String[] getRelationArray(String str) {
            if (getRelation(str) == RelationOperator.LE) return str.replace("<=", "\n").split("\n");
            if (getRelation(str) == RelationOperator.GE) return str.replace(">=", "\n").split("\n");
            if (getRelation(str) == RelationOperator.NE) return str.replace("!=", "\n").split("\n");
            if (getRelation(str) == RelationOperator.LT) return str.replace("<", "\n").split("\n");
            if (getRelation(str) == RelationOperator.GT) return str.replace(">", "\n").split("\n");
            if (getRelation(str) == RelationOperator.EQ) return str.replace("=", "\n").split("\n");
            return null;
        }

        public static boolean isCorrectPrerequisite(String obj1, String obj2, RelationOperator ro){
            if(ro == RelationOperator.EQ)
                if (obj1.equalsIgnoreCase(obj2)) return true; else return false;
            if(ro == RelationOperator.LT)
                if (Double.parseDouble(obj1) < Double.parseDouble(obj2)) return true; else return false;
            if(ro == RelationOperator.GT)
                if (Double.parseDouble(obj1) > Double.parseDouble(obj2)) return true; else return false;
            if(ro == RelationOperator.LE)
                if (Double.parseDouble(obj1) <= Double.parseDouble(obj2)) return true; else return false;
            if(ro == RelationOperator.GE)
                if (Double.parseDouble(obj1) >= Double.parseDouble(obj2)) return true; else return false;
            if(ro == RelationOperator.NE)
                if (!obj1.equalsIgnoreCase(obj2)) return true; else return false;
            return false;
        }
    }

    public static class InputStatement extends Statement {

        public InputStatement(TBekoCore tbc, String arg) {
            super(tbc, arg);
        }

        @Override
        public void run() {
            if (this.getArg().length() <= 0) {
                this.getTBekoCore().getInteractBlock().outWaring("INPUT Statement Does not have any Args to do.",this.getTBekoCore());
                return;
            }

            this.setArg(this.getArg().replace(" ", ",").replace(";", ""));
            while (this.getArg().contains(",,")) this.setArg(this.getArg().replace(",,", ","));

            String[] args = this.getArg().split(",");
            boolean b = false;
            for (String argStr : args) {
                if (!b) {
                    TObject to = this.getTBekoCore().getObjectMap().get(argStr.trim());
                    if (to != null && to.getType() == TObjectType.String) {
                        this.getTBekoCore().getInteractBlock().outMessage(to.toString(), false);
                        continue;
                    }
                }
                b = true;
                TObject data = this.getTBekoCore().getInteractBlock().inObject();
                this.getTBekoCore().getObjectMap().put(argStr, data);
            }
        }
    }

    public static class PrintStatement extends Statement {

        public PrintStatement(TBekoCore tbc, String arg) {
            super(tbc, arg);
        }

        @Override
        public void run() {
            if (this.getArg().length() <= 0) {
                return;
            }

            this.setArg(this.getArg().replace(" ", "").replace(";",","));
            String[] args = this.getArg().split(",");
            for (String argStr : args) {
                String output = this.getTBekoCore().counterString(argStr);

                if (output.charAt(0) == '\"') output = output.substring(1, output.length());
                if (output.charAt(output.length() - 1) == '\"') output = output.substring(0, output.length() - 1);

                this.getTBekoCore().getInteractBlock().outMessage(output,false);
            }
            this.getTBekoCore().getInteractBlock().outMessage("\r\n",false);
        }
    }


    public static class SetStatement extends Statement {
        public SetStatement(TBekoCore tbc, String arg) {
            super(tbc, arg);
        }

        @Override
        public void run() {
            if(getArg().split("=").length!=2){
                this.getTBekoCore().getInteractBlock().outError("Wrong Set Statement",this.getTBekoCore());
                return;
            }
            String[] arg = getArg().split("=");
            String[] arg_split = arg[1].split("&");
            String result = "";

            for(String str:arg_split) {
                if (str.charAt(0) == '\"') {
                    result += str.substring(1, str.length());
                } else {
                    if (this.getTBekoCore().isMathStatement(str)) {
                        Double d = null;
                        try {
                            d = new Double(this.getTBekoCore().counterString(str));
                            if (d.equals(Double.NaN)) {
                                this.getTBekoCore().getInteractBlock().outError("Wrong Set Statement",this.getTBekoCore());
                                return;
                            }
                        }catch (Exception e){
                            this.getTBekoCore().getInteractBlock().outError("Wrong Set Statement",this.getTBekoCore());
                            return;
                        }
                        if(d!=null) result += d.toString();
                    }
                }
            }

            if (isNumeric(result)) {
                this.getTBekoCore().putObject(arg[0],new TNumberObject(new BigDecimal(result)));
            }else{
                this.getTBekoCore().putObject(arg[0],new TStringObject(result));
            }
        }

        public static boolean isNumeric(String str) {
            String bigStr;
            try {
                bigStr = new BigDecimal(str).toString();
            } catch (Exception e) {
                return false;
            }
            return true;
        }
    }

    public static class WhileStatement extends Statement {
        public WhileStatement(TBekoCore tbc, String arg) {
            super(tbc, arg);
        }

        @Override
        public void run() {
            String pdStr = getArg().trim().replace(" ", "");

            RelationOperator ro = IfFunction.getRelation(pdStr);
            String[] strArray = IfFunction.getRelationArray(pdStr);
            if (strArray.length != 2) {
                this.getTBekoCore().getInteractBlock().outError("Wrong Relation Equation",this.getTBekoCore());
                return;
            }

            int WEND_line_num=-1;
            for(int i=this.getTBekoCore().getLineNum()+1;i<=this.getTBekoCore().getMaxLineNum();i++){
                if(this.getTBekoCore().getLineCode(i).trim().replace(" ","").equals("WEND")){
                    WEND_line_num = i;
                }
            }

            if(WEND_line_num==-1){
                this.getTBekoCore().getInteractBlock().outError("WHILE Statement Cannot Find a correct WEND Statement to correct.",this.getTBekoCore());
                return;
            }

            while(isRun(ro,strArray)){
                for(int i=this.getTBekoCore().getLineNum()+1;i<WEND_line_num;i++){
                    this.getTBekoCore().readLine(this.getTBekoCore().getLineCode(i));
                }
            }

            this.getTBekoCore().moveLineNum(WEND_line_num+1);
        }

        private boolean isRun(RelationOperator ro,String[] strArray){
            boolean isRun = false;
            if (IfFunction.isCorrectPrerequisite(this.getTBekoCore().counterString(strArray[0]),this.getTBekoCore().counterString(strArray[1]),ro))
                isRun = true;
            return isRun;
        }
    }

    public static abstract class Statement {
        private TBekoCore tbc;
        private String arg = "";

        public Statement(TBekoCore tbc, String arg) {
            if (arg != null)
                this.arg = arg;
            this.tbc = tbc;
        }

        public abstract void run();

        public String getArg() {
            return arg;
        }

        public void setArg(String arg) {
            this.arg = arg;
        }

        public TBekoCore getTBekoCore() {
            return tbc;
        }
    }

    public static class TNumberObject implements TObject {
        private BigDecimal value = new BigDecimal(0);

        public TNumberObject() {
        }

        public TNumberObject(double num) {
            this.value = new BigDecimal(num);
        }

        public TNumberObject(BigDecimal bd){
            this.value = bd;
        }

        @Override
        public TObjectType getType() {
            return TObjectType.Number;
        }

        public BigDecimal getBigDecimal() {
            return value;
        }

        public TNumberObject setBigDecimal(BigDecimal bd) {
            this.value = bd;
            return this;
        }

        public double getValue() {
            return value.doubleValue();
        }

        public TNumberObject setValue(double num) {
            this.value = new BigDecimal(num);
            return this;
        }

        public TNumberObject setValue(BigDecimal value) {
            this.value = value;
            return this;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }

    public static interface TObject {
        public TObjectType getType();

        @Override
        public String toString();
    }

    public enum TObjectType {
        Number, String
    }

    public static class TStringObject implements TObject {
        private String value;

        public TStringObject() {
        }

        public TStringObject(String value) {
            this.value = value;
        }

        @Override
        public TObjectType getType() {
            return TObjectType.String;
        }

        public String getValue() {
            return value;
        }

        public TStringObject setValue(String value) {
            this.value = value;
            return this;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public static class ArithHelper {
        private static final int DEF_DIV_SCALE = 16;

        private ArithHelper() {
        }

        public static double add(String v1, String v2) {
            BigDecimal b1 = new BigDecimal(v1), b2 = new BigDecimal(v2);
            return b1.add(b2).doubleValue();
        }

        public static double sub(String v1, String v2) {
            BigDecimal b1 = new BigDecimal(v1), b2 = new BigDecimal(v2);
            return b1.subtract(b2).doubleValue();
        }

        public static double mul(String v1, String v2) {
            BigDecimal b1 = new BigDecimal(v1), b2 = new BigDecimal(v2);
            return b1.multiply(b2).doubleValue();
        }

        public static double div(String v1, String v2) {
            BigDecimal b1 = new BigDecimal(v1), b2 = new BigDecimal(v2);
            return b1.divide(b2, DEF_DIV_SCALE, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        public static double quotient(String v1, String v2) {
            BigDecimal b1 = new BigDecimal(v1), b2 = new java.math.BigDecimal(v2);
            return b1.divide(b2).setScale(0, BigDecimal.ROUND_DOWN).doubleValue();
        }

        public static double mod(String v1, String v2) {
            BigDecimal b1 = new BigDecimal(v1), b2 = new BigDecimal(v2);
            return b1.divideAndRemainder(b2)[1].doubleValue();
        }
    }

    public static class Calculator {
        private Stack<String> postfixStack = new Stack<String>();
        private Stack<Character> opStack = new Stack<Character>();
        private int[] operatPriority = new int[]{0, 3, 2, 1, -1, 1, 0, 2};

        public static double conversion(String expression) {
            double result = 0;
            Calculator cal = new Calculator();
            if(expression.replace("0","").replace("1","").replace("2","").replace("3","").replace("4","")
                    .replace("5","").replace("6","").replace("7","").replace("8","").replace("9","").replace(" ","").equals("")){
                expression += "+0";
            }
            try {
                expression = transform(expression);
                result = cal.calculate(expression);
            } catch (Exception e) {
                return Double.NaN;
            }
            return result;
        }

        private static String transform(String expression) {
            char[] arr = expression.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '-') {
                    if (i == 0) {
                        arr[i] = '~';
                    } else {
                        char c = arr[i - 1];
                        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '\\' || c == '%' || c == '(' || c == 'E' || c == 'e') {
                            arr[i] = '~';
                        }
                    }
                }
            }
            if (arr[0] == '~' || arr[1] == '(') {
                arr[0] = '-';
                return "0" + new String(arr);
            } else {
                return new String(arr);
            }
        }

        public static boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/' || c == '\\' || c == '%' || c == '(' || c == ')';
        }

        public static boolean isNumber(char c) {
            return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7'|| c == '8' || c == '9';
        }

        public static boolean isHaveOperator(String str) {
            boolean b = false;
            for (char c : str.toCharArray())
                if (isOperator(c))
                    b = true;
                else
                if(isNumber(c))
                    b = true;
            return b;
        }

        public double calculate(String expression) {
            Stack<String> resultStack = new Stack<String>();
            prepare(expression);
            Collections.reverse(postfixStack);
            String firstValue, secondValue, currentValue;
            while (!postfixStack.isEmpty()) {
                currentValue = postfixStack.pop();
                if (!isOperator(currentValue.charAt(0))) {
                    currentValue = currentValue.replace("~", "-");
                    resultStack.push(currentValue);
                } else {
                    secondValue = resultStack.pop();
                    firstValue = resultStack.pop();

                    firstValue = firstValue.replace("~", "-");
                    secondValue = secondValue.replace("~", "-");

                    String tempResult = calculate(firstValue, secondValue, currentValue.charAt(0));
                    resultStack.push(tempResult);
                }
            }
            return Double.valueOf(resultStack.pop());
        }


        private void prepare(String expression) {
            opStack.push(',');
            char[] arr = expression.toCharArray();
            int currentIndex = 0;
            int count = 0;
            char currentOp, peekOp;
            for (int i = 0; i < arr.length; i++) {
                currentOp = arr[i];
                if (isOperator(currentOp)) {
                    if (count > 0) {
                        postfixStack.push(new String(arr, currentIndex, count));
                    }
                    peekOp = opStack.peek();
                    if (currentOp == ')') {
                        while (opStack.peek() != '(') {
                            postfixStack.push(String.valueOf(opStack.pop()));
                        }
                        opStack.pop();
                    } else {
                        while (currentOp != '(' && peekOp != ',' && compare(currentOp, peekOp)) {
                            postfixStack.push(String.valueOf(opStack.pop()));
                            peekOp = opStack.peek();
                        }
                        opStack.push(currentOp);
                    }
                    count = 0;
                    currentIndex = i + 1;
                } else {
                    count++;
                }
            }
            if (count > 1 || (count == 1 && !isOperator(arr[currentIndex]))) {
                postfixStack.push(new String(arr, currentIndex, count));
            }

            while (opStack.peek() != ',') {
                postfixStack.push(String.valueOf(opStack.pop()));
            }
        }

        public boolean compare(char cur, char peek) {
            boolean result = false;
            if (operatPriority[(peek) - 40] >= operatPriority[(cur) - 40]) {
                result = true;
            }
            return result;
        }

        private String calculate(String firstValue, String secondValue, char currentOp) {
            String result = "";
            switch (currentOp) {
                case '+':
                    result = String.valueOf(ArithHelper.add(firstValue, secondValue));
                    break;
                case '-':
                    result = String.valueOf(ArithHelper.sub(firstValue, secondValue));
                    break;
                case '*':
                    result = String.valueOf(ArithHelper.mul(firstValue, secondValue));
                    break;
                case '/':
                    result = String.valueOf(ArithHelper.div(firstValue, secondValue));
                    break;
                case '\\':
                    result = String.valueOf(ArithHelper.quotient(firstValue, secondValue));
                    break;
                case '%':
                    result = String.valueOf(ArithHelper.mod(firstValue, secondValue));
                    break;
            }
            return result;
        }
    }

    public static class DefaultInteractBlock implements IInteractBlock {
        @Override
        public void outWaring(String message, int line, String code) {
            System.err.println("[WARING] " + message);
            System.err.println("  at line " + line + " :: " + code);
        }

        @Override
        public void outError(String message, int line, String code) {
            System.err.println("[ERROR] " + message);
            System.err.println("  at line " + line + " :: " + code);
        }

        @Override
        public void outWaring(String message, TBekoCore tbc) {
            this.outWaring(message,tbc.getLineNum(),tbc.getLineCode(tbc.getLineNum()));
        }

        @Override
        public void outError(String message, TBekoCore tbc) {
            this.outError(message,tbc.getLineNum(),tbc.getLineCode(tbc.getLineNum()));
        }

        @Override
        public void outMessage(String message) {
            this.outMessage(message, true);
        }

        @Override
        public void outMessage(String message, boolean b) {
            if (b)
                System.out.println(message);
            else
                System.out.print(message);
        }

        @Override
        public TObject inObject() {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();

            if (Pattern.compile("[0-9]*").matcher(str).matches()) {
                return new TNumberObject(new BigDecimal(str));
            } else {
                return new TStringObject(str);
            }
        }

        @Override
        public TStringObject inStringObject() {
            TObject to = this.inObject();
            return new TStringObject(to.toString());
        }

        @Override
        public TNumberObject inNumberObject() {
            TObject to = this.inObject();
            if (to.getType() == TObjectType.Number)
                return (TNumberObject) to;
            else
                return this.inNumberObject();
        }
    }

    public static interface IInteractBlock {
        public void outWaring(String message, int line, String code);

        public void outError(String message, int line, String code);

        public void outWaring(String message, TBekoCore tbc);

        public void outError(String message, TBekoCore tbc);

        public void outMessage(String message);

        public void outMessage(String message, boolean b);

        public TObject inObject();

        public TStringObject inStringObject();

        public TNumberObject inNumberObject();
    }






}

