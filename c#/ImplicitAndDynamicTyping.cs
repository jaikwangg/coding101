using System;

namespace ImplicitAndDynamicTyping
{
    class Program
    {
        static void Main(string[] args)
        {
            //implicit
            var number = 10;
            var message = "implicit";
            
            Console.WriteLine($"Number: {number}, Type: {number.GetType()}");
            Console.WriteLine($"Message: {message}, Type: {message.GetType()}");

            //dynamic
            dynamic dynamicVariable = 20;
            Console.WriteLine($"Dynamic Variable: {dynamicVariable}, Type: {dynamicVariable.GetType()}");

            dynamicVariable = "dynamic";
            Console.WriteLine($"Dynamic Variable: {dynamicVariable}, Type: {dynamicVariable.GetType()}");
        }
    }
}
