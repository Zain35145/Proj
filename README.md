# Proj
using System;
using System.Collections.Generic;
using System.IO;

namespace TextFileComparator
{
    class Program
    {
        static List<string[]> fileContents;
        static int currentIndex;

        static void Main(string[] args)
        {
            Console.WriteLine("Enter the path to the directory containing the text files:");
            string directoryPath = Console.ReadLine();
            string[] files = Directory.GetFiles(directoryPath);

            fileContents = new List<string[]>();

            for (int i = 0; i < files.Length; i++)
            {
                string[] lines = File.ReadAllLines(files[i]);
                fileContents.Add(lines);
            }

            currentIndex = -1;

            ConsoleKeyInfo keyInfo;

            do
            {
                keyInfo = Console.ReadKey();

                if (keyInfo.Key == ConsoleKey.UpArrow)
                {
                    if (currentIndex - 2 >= 0)
                    {
                        currentIndex -= 2;
                        DisplayFileComparison(fileContents[currentIndex], fileContents[currentIndex + 1]);
                    }
                }
                else
                {
                    currentIndex += 2;

                    if (currentIndex < fileContents.Count)
                    {
                        if (currentIndex - 2 >= 0)
                        {
                            Console.WriteLine("Press the up arrow key to view the previous two files' text. Press any other key to continue.");
                        }

                        DisplayFileComparison(fileContents[currentIndex - 2], fileContents[currentIndex - 1]);
                    }
                    else if (currentIndex == fileContents.Count - 1)
                    {
                        Console.WriteLine("The last file couldn't be compared because there wasn't another file to pair it with.");
                        break;
                    }
                    else
                    {
                        Console.WriteLine("No more files to compare.");
                        break;
                    }
                }
            }
            while (keyInfo.Key != ConsoleKey.Escape);

            Console.WriteLine("Press any key to exit.");
            Console.ReadKey();
        }

        static void DisplayFileComparison(string[] file1Lines, string[] file2Lines)
        {
            Console.Clear();
            Console.WriteLine("Text comparison:");
            Console.WriteLine();

            for (int i = 0; i < Math.Max(file1Lines.Length, file2Lines.Length); i++)
            {
                if (i < file1Lines.Length && i < file2Lines.Length)
                {
                    if (file1Lines[i] == file2Lines[i])
                    {
                        Console.WriteLine(file1Lines[i]);
                    }
                    else
                    {
                        string comparedLine = CompareLines(file1Lines[i], file2Lines[i]);
                        Console.WriteLine(comparedLine);
                    }
                }
                else if (i < file1Lines.Length)
                {
                    Console.WriteLine(file1Lines[i]);
                }
                else if (i < file2Lines.Length)
                {
                    Console.WriteLine(file2Lines[i]);
                }
            }

            Console.WriteLine();
        }

        static string CompareLines(string line1, string line2)
        {
            string[] words1 = line1.Split(' ');
            string[] words2 = line2.Split(' ');

            string comparedLine = "";

            for (int i = 0; i < Math.Max(words1.Length, words2.Length); i++)
            {
                if (i < words1.Length && i < words2.Length)
                {
                    if (words1[i] == words2[i])
                    {
                        comparedLine += words1[i] + " ";
                    }
                    else
                    {
                        comparedLine += "**" + words1[i] + "** ";
                    }
                }
                else if (i < words1.Length)
                {
                    comparedLine += "**" + words1[i] + "** ";
                }
                else if (i < words2.Length)
                {
                    comparedLine += "**" + words2[i] + "** ";
                }
            }

            return comparedLine.Trim();
        }
    }
}
