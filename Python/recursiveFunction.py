#include <stdio.h>
#include <math.h>

int main() {
    double A, B, C;

    // รับค่า A, B, C จากผู้ใช้
    printf("Enter coefficients A, B, and C: ");
    scanf("%lf %lf %lf", &A, &B, &C);

    if (A == 0) {
        // กรณี a = 0

        if (B == 0) {
            // กรณี B = 0 สมการไม่มีตัวแปร x
            printf("The equation is a constant equation.\n");
        } else {
            // สมการเชิงเส้น Bx + C = 0
            double root = -C / B;
            printf("The equation is a linear equation.\n");
            printf("Root = %.2lf\n", root);
        }
    } else {
        // คำนวณ discriminant
        double discriminant = B * B - 4 * A * C;

        // ตรวจสอบค่า discriminant
        if (discriminant > 0) {
            // คำนวณและแสดงคำตอบทั้งสอง
            double root1 = (-B + sqrt(discriminant)) / (2 * A);
            double root2 = (-B - sqrt(discriminant)) / (2 * A);
            printf("Roots are real and different.\n");
            printf("Root 1 = %.2lf\n", root1);
            printf("Root 2 = %.2lf\n", root2);
        } else if (discriminant == 0) {
            // คำนวณและแสดงคำตอบที่เป็นจำนวนจริงเดียว
            double root = -B / (2 * A);
            printf("Roots are real and the same.\n");
            printf("Root = %.2lf\n", root);
        } else {
            // แจ้งเตือนว่าไม่มีคำตอบจริงในเลขจำนวนจริง
            printf("Roots are complex and different.\n");
        }
    }

    return 0;
}