/**
 * CustomException class allows pre-defined Exceptions to be thrown.
 * Requires try() catch() implementation.
 */
public class CustomException extends Exception{
	public CustomException( String message )
    {
 	 super( message );
    }
}
