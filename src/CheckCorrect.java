public class CheckCorrect
{
    // проверка на длину
    static boolean CheckCorrectLengthInput( String[] input)
    {
        if(input.length != 3)
        {
            return false;
        }
        return true;
    }

    static boolean CheckActionOperator( String input)
    {
        if(!input.contains("+") && !input.contains("-")
                && !input.contains("*") && !input.contains("/"))
        {
            return false;
        }
        return true;
    }


}
