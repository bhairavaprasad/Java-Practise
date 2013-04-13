package com.tsswireless.ttable.tailer;

import java.awt.Color;
import java.util.StringTokenizer;

import org.jdom.Element;

/**
 * Simple substring matching rule that holds the background and foreground colors
 * for String that match the substring
 *
 * @author shaines
 */
public class TailerRule
{
    private String match;

    private Color foreground;

    private Color background;

    public TailerRule()
    {
    }

    public TailerRule( Element e )
    {
        match = e.getAttributeValue( "match" );
        background = getColor( e.getAttributeValue( "background" ) );
        foreground = getColor( e.getAttributeValue( "foreground" ) );
    }

    /**
     * Converts a String to a Color
     * 
     * @param s                 The String to convert
     *
     * @return                  The resultant color object
     */
    private Color getColor( String s )
    {
        if( s.equalsIgnoreCase( "WHITE" ) )
        {
            return Color.WHITE;
        }
        else if( s.equalsIgnoreCase( "BLACK" ) )
        {
            return Color.BLACK;
        }
        else if( s.equalsIgnoreCase( "BLUE" ) )
        {
            return Color.BLUE;
        }
        else if( s.equalsIgnoreCase( "GREEN" ) )
        {
            return Color.GREEN;
        }
        else if( s.equalsIgnoreCase( "RED" ) )
        {
            return Color.RED;
        }
        else if( s.equalsIgnoreCase( "YELLOW" ) )
        {
            return Color.YELLOW;
        }
        else if( s.equalsIgnoreCase( "ORANGE" ) )
        {
            return Color.ORANGE;
        }
        else if( s.equalsIgnoreCase( "GRAY" ) )
        {
            return Color.GRAY;
        }
        else if( s.equalsIgnoreCase( "LIGHT_GRAY" ) )
        {
            return Color.LIGHT_GRAY;
        }
        else if( s.equalsIgnoreCase( "CYAN" ) )
        {
            return Color.CYAN;
        }
        else if( s.equalsIgnoreCase( "DARK_GRAY" ) )
        {
            return Color.DARK_GRAY;
        }
        else if( s.equalsIgnoreCase( "MAGENTA" ) )
        {
            return Color.MAGENTA;
        }
        else if( s.equalsIgnoreCase( "PINK" ) )
        {
            return Color.PINK;
        }
        else if( s.indexOf( ',' ) != -1 )
        {
            StringTokenizer st = new StringTokenizer( s, ",", false );
            if( st.countTokens() == 3 )
            {
                // RGB values
                return new Color( Integer.parseInt( st.nextToken() ),
                        Integer.parseInt( st.nextToken() ),
                        Integer.parseInt( st.nextToken() ) );
            }
        }
        else
        {
            System.out.println( "Unknown color: " + s );
        }

        return Color.BLACK;
    }

    /**
     * Implements the matching logic to determine whether or not the specified line
     * is a match for this rule
     *
     * @param line                  The line of text to evaluate
     *
     * @return                      True if the line is a match, false if it is not
     */
    public boolean match( String line )
    {
        if(match != null && line.toUpperCase().indexOf( match.toUpperCase() ) != -1 )
        {
            return true;
        }
        return false;
    }

    public Color getBackground()
    {
        return background;
    }

    public void setBackground( Color background )
    {
        this.background = background;
    }

    public Color getForeground()
    {
        return foreground;
    }

    public void setForeground( Color foreground )
    {
        this.foreground = foreground;
    }

    public String getMatch()
    {
        return match;
    }

    public void setMatch( String match )
    {
        this.match = match;
    }
}

