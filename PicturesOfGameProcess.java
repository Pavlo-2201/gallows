package project1.gallows;

public class PicturesOfGameProcess {
    private static final String[] pictures = {
            """
    ------   
    |       
    |       
    |       
    |
    |       
    ---------- 
    """,
            """
     ------   
     |    |   
     |    O   
     |       
     |
     |       
     ---------- 
     """,
            """
    ------   
    |    |   
    |    O   
    |    |   
    |
    |       
    ----------
    """,
            """
    ------   
    |    |   
    |    O   
    |   /|   
    |
    |       
    ----------           
     """,
            """
    ------   
    |    |   
    |    O   
    |   /|\\   
    |
    |       
    -----------           
     """,
            """
    ------   
    |    |   
    |    O   
    |   /|\\   
    |  _/
    |   
    ----------           
     """,
            """
    ------   
    |    |   
    |    O   
    |   /|\\   
    |  _/ \\_ 
    |  
    ----------           
     """
    };

    static String printPicture(int numPicture) {
        return pictures[numPicture];
    }
}
