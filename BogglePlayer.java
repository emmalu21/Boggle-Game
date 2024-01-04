/*

  Authors (group members): Isabella MacDonald, Dorothy Ammons, Emma Bahr
  Email addresses of group members: imacdonald2022@my.fit.edu, 
  Group name: The Exceptions

  Course: CSE 2010
  Section: 12

  Description of the overall algorithm and key data structures:

  https://www.w3schools.com/java/java_files_read.asp

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class BogglePlayer
{

    Trie root = new Trie(' ');
    // initialize BogglePlayer with a file of English words
    public BogglePlayer(String wordFile) throws FileNotFoundException
    {
      File words = new File(wordFile);
      Scanner reader = new Scanner(words);

      while (reader.hasNextLine()) {
        String newWord = reader.nextLine().toUpperCase();
        if (newWord.length() <= 16) {
          root.addWord(newWord, root);
        }
      }
    }

    // based on the board, find valid words
    //
    // board: 4x4 board, each element is a letter, 'Q' represents "QU", 
    //    first dimension is row, second dimension is column
    //    ie, board[row][col]     
    //
    // Return at most 20 valid words in UPPERCASE and 
    //    their paths of locations on the board in myWords;
    //    Use null if fewer than 20 words.
    //
    // See Word.java for details of the Word class and
    //     Location.java for details of the Location class

    public Word[] getWords(char[][] board)
    {
  Word[] myWords = new Word[20];
  char[][] copyBoard = new char[4][4];
  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 4; j++) {
      copyBoard[i][j] = board[i][j];
    }
  }

  for(int k = 0; k < 4; k++) {
    for (int m = 0; m < 4; m++) {
      char s = board[k][m];
      String starter = "";
      starter += s;
      myWords = Recursion(starter, copyBoard, m, s, myWords); 
    }
  }
        return myWords;
    }


public Word[] Recursion(String word, char[][] board, int row, int col, Word[] myWords) {
 while (myWords[19] != null) {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (board[i][j] != ' ') {
          if (j == col-1) {
            if (i == row+1) {
              // diagonally
              if (board[i][j] == 'Q') {
                word = word + "QU";
              } else {
                word = word + board[i][j];
              }
              if (word.length() > 2) {
                if (Trie.test(word, root)) {
                  for (int m = 0; m < 20; m++) {
                    if (myWords[m] == null) {
                      Word trial = new Word(word);
                      myWords[m] = trial;
                      m = 20;
                    }
                  }
                }
              }
              board[i][j] = ' ';
              return Recursion(word, board, row+1, col-1, myWords);
            } else if (i == row-1) {
             // diagonally
             if (board[i][j] == 'Q') {
                word = word + "QU";
              } else {
                word = word + board[i][j];
              }
              if (word.length() > 2) {
                if (Trie.test(word, root)) {
                  for (int m = 0; m < 20; m++) {
                    if (myWords[m] == null) {
                      Word trial = new Word(word);
                      myWords[m] = trial;
                      m = 20;
                    }
                  }
                }
              }
              board[i][j] = ' ';
              return Recursion(word, board, row-1, col-1, myWords);
            } else if (i == row) {
              //next to it
              if (board[i][j] == 'Q') {
                word = word + "QU";
              } else {
                word = word + board[i][j];
              }
              if (word.length() > 2) {
                if (Trie.test(word, root)) {
                  for (int m = 0; m < 20; m++) {
                    if (myWords[m] == null) {
                      Word trial = new Word(word);
                      myWords[m] = trial;
                      m = 20;
                    }
                  }
                }
              }
              board[i][j] = ' ';
              return Recursion(word, board, row, col-1, myWords);
            }
          }
          if (j == col+1) {
            if (i == row+1) {
              // diagonally
              if (board[i][j] == 'Q') {
                word = word + "QU";
              } else {
                word = word + board[i][j];
              }
              if (word.length() > 2) {
                if (Trie.test(word, root)) {
                  for (int m = 0; m < 20; m++) {
                    if (myWords[m] == null) {
                      Word trial = new Word(word);
                      myWords[m] = trial;
                      m = 20;
                    }
                  }
                }
              }
              board[i][j] = ' ';
              return Recursion(word, board, row+1, col+1, myWords);
            } else if (i == row-1) {
              // diagonally
              if (board[i][j] == 'Q') {
                word = word + "QU";
              } else {
                word = word + board[i][j];
              }
              if (word.length() > 2) {
                if (Trie.test(word, root)) {
                  for (int m = 0; m < 20; m++) {
                    if (myWords[m] == null) {
                      Word trial = new Word(word);
                      myWords[m] = trial;
                      m = 20;
                    }
                  }
                }
              }
              board[i][j] = ' ';
              return Recursion(word, board, row-1, col+1, myWords);
            } else if (i == row) {
              //next to it
              if (board[i][j] == 'Q') {
                word = word + "QU";
              } else {
                word = word + board[i][j];
              }
              if (word.length() > 2) {
                if (Trie.test(word, root)) {
                  for (int m = 0; m < 20; m++) {
                    if (myWords[m] == null) {
                      Word trial = new Word(word);
                      myWords[m] = trial;
                      m = 20;
                    }
                  }
                }
              }
              board[i][j] = ' ';
              return Recursion(word, board, row, col+1, myWords);
            }
          }
          if (j == col) {
            if (i == row+1) {
              // above
              if (board[i][j] == 'Q') {
                word = word + "QU";
              } else {
                word = word + board[i][j];
              }
              if (word.length() > 2) {
                if (Trie.test(word, root)) {
                  for (int m = 0; m < 20; m++) {
                    if (myWords[m] == null) {
                      Word trial = new Word(word);
                      myWords[m] = trial;
                      m = 20;
                    }
                  }
                }
              }
              board[i][j] = ' ';
              return Recursion(word, board, row+1, col, myWords);
            } else if (i == row-1) {
              // below
              if (board[i][j] == 'Q') {
                word = word + "QU";
              } else {
                word = word + board[i][j];
              }
              if (word.length() > 2) {
                if (Trie.test(word, root)) {
                  for (int m = 0; m < 20; m++) {
                    if (myWords[m] == null) {
                      Word trial = new Word(word);
                      myWords[m] = trial;
                      m = 20;
                    }
                  }
                }
              }
              board[i][j] = ' ';
              return Recursion(word, board, row-1, col, myWords);
            }
          }
        }
      }
    }
 }
 return myWords;
}
}