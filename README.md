# IMDB-TestAutuomation
This project demonstrates automation of three test cases for the IMDb website using Selenium WebDriver in Java. These test cases include:

1.Playing a movie trailer.
2.Capturing and displaying the movie's IMDb rating.
3.Retrieving and displaying recently visited movie titles.
**Table of Contents**
i.Technologies Used
ii.Setup Instructions
iii.Test Case Details
iv.Execution Instructions

**Technologies Used**
Java (JDK 8 or later)
Selenium WebDriver (v4.0+)
Google Chrome (latest version)
ChromeDriver (compatible with your Chrome version)
**Setup Instructions****
1.Clone the repository:
git clone https://github.com/your-repo/imdb-test-cases.git
cd imdb-test-cases
2.Install the required libraries by adding the Selenium dependency to your pom.xml if using Maven:
xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.1.2</version>
</dependency>
3.Download the latest version of ChromeDriver and ensure it is accessible from your system's PATH or configure its path in your code.
4.Set up the IMDb project in your IDE (e.g., IntelliJ IDEA, Eclipse).
**Test Case Details**

1. Playing a Movie Trailer
This test case navigates to the IMDb homepage, searches for a specific movie, and plays its trailer.
Method: playTrailer
Key Steps:
Open the IMDb homepage.
Search for the movie kgf 2022.
Click on the movie trailer and play it.

2. Capturing and Displaying Movie Rating
This test case retrieves and displays the IMDb rating of a specific movie.
Method: captureRating
Key Steps:
Search for kgf 2022 on IMDb.
Extract and display the movie rating from the webpage.
3. Retrieving Recently Visited Titles
   
This test case searches for multiple movies and retrieves their titles from the "Recently Visited" section.
Method: recentlyVisited
Key Steps:
Search for kgf 2022, salar ghajar, and No where.
Navigate to the homepage.
Display titles from the recently visited movies list.
**Execution Instructions**
Run the test cases using the main method in IMDbTestCases.java. Each test case is invoked sequentially.
The main method:
public static void main(String[] args) {
    try {
        playTrailer(); // Play a movie trailer
        captureRating(); // Capture movie rating
        recentlyVisited(); // Display recently visited titles
    } catch (Exception e) {
        System.err.println("Error in main execution: " + e.getMessage());
    }
}
**Expected outputs:**
Success messages for playing the trailer.
IMDb rating of the movie.
List of recently visited movie titles.
