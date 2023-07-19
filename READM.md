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

            if (fileContents.Count < 2)
            {
                Console.WriteLine("Insufficient number of files for comparison.");
                Console.WriteLine("Press any key to exit.");
                Console.ReadKey();
                return;
            }

            ConsoleKeyInfo keyInfo;

            do
            {
                currentIndex += 2;

                if (currentIndex >= fileContents.Count)
                {
                    Console.WriteLine("No more files to compare.");
                    break;
                }

                if (currentIndex > 1)
                {
                    Console.WriteLine("Press the up arrow key to view the previous two files' text. Press any other key to continue.");
                }

                DisplayFileComparison(fileContents[currentIndex - 2], fileContents[currentIndex - 1]);

                keyInfo = Console.ReadKey();
                if (keyInfo.Key == ConsoleKey.UpArrow && currentIndex >= 4)
                {
                    currentIndex -= 4;
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
