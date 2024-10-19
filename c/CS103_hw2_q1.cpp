#include <iostream>
using namespace std;

int main() {
    const int numStudents = 20;
    char grades[numStudents]; 
    int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

    cout << "Please enter the grades of " << numStudents << " students (A, B, C, D, F):" << endl;
    for (int i = 0; i < numStudents; i++) {
        cout << "Student " << (i + 1) << ": ";
        cin >> grades[i];

        while (grades[i] != 'A' && grades[i] != 'B' && grades[i] != 'C' && grades[i] != 'D' && grades[i] != 'F') {
            cout << "Incorrect grade, please enter A, B, C, D, or F: ";
            cin >> grades[i];
        }

        switch (grades[i]) {
            case 'A': countA++; break;
            case 'B': countB++; break;
            case 'C': countC++; break;
            case 'D': countD++; break;
            case 'F': countF++; break;
        }
    }

    // output
    cout << "\nGrades Frequency:\n";
    cout << "------------------\n";
    cout << "A: " << string(countA, '*') << " (" << countA << ")\n";
    cout << "B: " << string(countB, '*') << " (" << countB << ")\n";
    cout << "C: " << string(countC, '*') << " (" << countC << ")\n";
    cout << "D: " << string(countD, '*') << " (" << countD << ")\n";
    cout << "F: " << string(countF, '*') << " (" << countF << ")\n";

    return 0;
}
