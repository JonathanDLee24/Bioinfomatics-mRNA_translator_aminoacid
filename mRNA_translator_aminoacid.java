/*
Author: Jonathan Lee
CSCI Professor: Gita Faroughi
Biology Professor: Cody Watters Section 1, Dr. Priscilla Issac Section 2 Sacramento State University
Class: CSCI13 Grader
Date: Nov 7 2022
Program: Bioinfomatics translate an mRNA transcript into a sequence of amino acids.
*/
import java.util.*;
public class mRNA_translator_aminoacid
{
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Enter DNA sequence:");
      String mRNA = transcribe(console.next());
      //System.out.println(mRNA.length()); //test point only valid counts are A,C,G,T 
      while(mRNA.length()%3 != 0)//data validation must take triplets only and will count only DNA A C G or T
      {
         System.out.print("Please enter only tripletts and use correct entries for DNA A, C, G, or T:");
         mRNA = transcribe(console.next()); //test new entry until %3 = 0
      }
      System.out.println("Transcribed: "+ mRNA);
      System.out.println("Amino Acids: "+AminoAcids(mRNA));
   }
   
   /* This private method will transcribe a sequence of dna. A=U G=C if T=A RNA does not contain T.*/
   private static String transcribe(String DNA)
   {
      DNA = DNA.toUpperCase();
      String mRNA = "";
      for(int i = 0; i<DNA.length(); i++)
      {
         char check  = DNA.charAt(i);
         switch(check)
         {
            case ('A'): 
            {
               mRNA += 'U';
               continue;
            }
            case ('T'):
            {
               mRNA += 'A';
               continue;
            }
            case ('G'):
            {
               mRNA += 'C';
               continue;
            }
            case ('C'):
            {
               mRNA += 'G';
               continue;
            }
            default: 
            {
               continue;
            }
         }
      }
      return mRNA;
   }
   
   /* This method will determine the amino acid sequence that would be produced from the sequence after transcription. 
   Per Professor Cody Watters if stop UAA, UAG, or UGA is seen the Amino Acid sequence is completed the rest is ignored see return area.
   Start must also be AUG before code starts*/
   private static String AminoAcids(String mRNA)
   {
   
      String AminoAcids = "";
      boolean flag = false;//used with start AUG MET
      for(int i = 0; i<mRNA.length(); i+=3)
      {
         String check  = mRNA.substring(i, i+3);
         switch(check)
         {
            case ("UUU"): case ("UUC"): 
            {
               if(flag)
               {
                  AminoAcids += "Phe-";
               }
               continue;
            }
            case ("UCU"): case ("UCC"):
            case ("UCA"): case ("UCG"):
            {
               if(flag)
               {
                  AminoAcids += "Ser-";
               }
               continue;
            }
            case ("UAU"): case ("UAC"): 
            {
               if(flag)
               {
                  AminoAcids += "Tyr-";
               }
               continue;
            }
            case ("UAA"): case ("UAG"): //stop case
            case ("UGA"):
            {
               if(flag)
               {
                  AminoAcids += "STOP ";
               }
               return AminoAcids;
            }
            case ("UGU"): case ("UGC"): 
            {
               if(flag)
               {
                  AminoAcids += "Cys-";
               }
               continue;
            }
            case ("UGG"):
            {
               if(flag)
               {
                  AminoAcids += "Trp-";
               }
               continue;
            }
            case ("CUU"): case ("CUC"):
            case ("CUA"): case ("CUG"):
            case ("UUA"): case ("UUG"):
            {
               if(flag)
               {
                  AminoAcids += "Leu-";
               }
               continue;
            }
            case ("CCU"): case ("CCC"):
            case ("CCA"): case ("CCG"):
            {
               if(flag)
               {
                  AminoAcids += "Pro-";
               }
               continue;
            }
            case ("CAU"): case ("CAC"): 
            {
               if(flag)
               {
                  AminoAcids += "His-";
               }
               continue;
            }
            case ("CAA"): case ("CAG"): 
            {
               if(flag)
               {
                  AminoAcids += "Gin-";
               }
               continue;
            }
            case ("CGU"): case ("CGC"):
            case ("CGA"): case ("CGG"):
            {
               if(flag)
               {
                  AminoAcids += "Arg-";
               }
               continue;
            }
            case ("AUU"): case ("AUC"):
            case ("AUA"):
            {
               if(flag)
               {
                  AminoAcids += "Ile-";
               }
               continue;
            }
            case ("AUG")://start case will turn flag on for to find sequence until stop is found
            {
               AminoAcids += "START Met-";
               flag = true;
               continue;
            }
            case ("ACU"): case ("ACC"):
            case ("ACA"): case ("ACG"):
            {
               if(flag)
               {
                  AminoAcids += "Thr-";
               }
               continue;
            }
            case ("AAU"): case ("AAC"): 
            {
               if(flag)
               {
                  AminoAcids += "Asn-";
               }
               continue;
            }
            case ("AAA"): case ("AAG"): 
            {
               if(flag)
               {
                  AminoAcids += "Lys-";
               }
               continue;
            }
            case ("AGU"): case ("AGC"): 
            {
               if(flag)
               {
                  AminoAcids += "Ser-";
               }
               continue;
            }
            case ("AGA"): case ("AGG"): 
            {
               if(flag)
               {
                  AminoAcids += "Arg-";
               }
               continue;
            }
            case ("GUU"): case ("GUC"):
            case ("GUA"): case ("GUG"):
            {
               if(flag)
               {
                  AminoAcids += "Val-";
               }
               continue;
            }
            case ("GCU"): case ("GCC"):
            case ("GCA"): case ("GCG"):
            {
               if(flag)
               {
                  AminoAcids += "Ala-";
               }
               continue;
            }
            case ("GAU"): case ("GAC"):
            { 
               if(flag)
               {
                  AminoAcids += "Asp-";
               }
               continue;
            }
            case ("GAA"): case ("GAG"):
            {
               if(flag)
               {
                  AminoAcids += "Glu-";
               }
               continue;
            }
            case ("GGU"): case ("GGC"):
            case ("GGA"): case ("GGG"):
            {
               if(flag)
               {
                  AminoAcids += "Gly-";
               }
               continue;
            }
            default: 
            {
               continue;
            }
         }
      }
      return AminoAcids;
   }
}
