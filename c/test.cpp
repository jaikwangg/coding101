//CS103_hw2_q1
#include <iostream>
using namespace std;

int main() {
    char grades[20]; // collect student grades
    int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

    // get information
    cout << "please enter the grades of 20 studens (A, B, C, D, F):" << endl;
    for (int i = 0; i < 20; i++) {
        cout << "students" << (i + 1) << ": ";
        cin >> grades[i];

        // calculate the frequency using switch
        switch (grades[i]) {
            case 'A':
                countA++;
                break;
            case 'B':
                countB++;
                break;
            case 'C':
                countC++;
                break;
            case 'D':
                countD++;
                break;
            case 'F':
                countF++;
                break;
            default:
                cout << "incorrect grades please fill in A, B, C, D or F" << endl;
                i--; // Reduce i to re-fill
                break;
        }
    }

    // output
    cout << "\n grades frequency:\n";
    cout << "A: " << string(countA, '*') << " (" << countA << ")\n";
    cout << "B: " << string(countB, '*') << " (" << countB << ")\n";
    cout << "C: " << string(countC, '*') << " (" << countC << ")\n";
    cout << "D: " << string(countD, '*') << " (" << countD << ")\n";
    cout << "F: " << string(countF, '*') << " (" << countF << ")\n";

    return 0;
}