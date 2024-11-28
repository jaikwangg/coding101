using System;

class Chatbot
{
    public void Start()
    {
        Console.WriteLine("Welcome to bot Healthcare KMUTT Chatbot");
        Console.WriteLine("How can I help you today?");
        
        while (true)
        {
            string userInput = Console.ReadLine().ToLower();

            if (userInput == "go")
            {
                Console.WriteLine("Ok let's start. What is your problem today?");
                string healthInput = Console.ReadLine().ToLower();
            }
            else if (userInput == "exit")
            {
                Console.WriteLine("Goodbye! Have a good day.");
                break;
            }
            else if (userInput == "headache")
            {
                Console.WriteLine(
                    "A headache happens when pain-sensitive areas in your head " +
                    "such as nerves, blood vessels, or muscles, become irritated or tense. " +
                    "This can be caused by stress, dehydration, poor posture, or underlying medical conditions.");
                
                Console.WriteLine("Would you like some advice on how to fix it? (yes/no)");
                string healthInput = Console.ReadLine().ToLower();

                if (healthInput == "yes")
                {
                    ProvideHealthAdvice("headache");
                }
                else
                {
                    Console.WriteLine("Okay! Let me know if you need help.");
                }
            }
            else if (userInput == "stomachache")
            {
                Console.WriteLine("A stomachache can be caused by indigestion, gas, or other issues.");
                Console.WriteLine("Would you like some advice on how to fix it? (yes/no)");
                string healthInput = Console.ReadLine().ToLower();

                if (healthInput == "yes")
                {
                    ProvideHealthAdvice("stomachache");
                }
                else
                {
                    Console.WriteLine("Okay! Let me know if you need help.");
                }
            }
            else if (userInput == "thanks")
            {
                Console.WriteLine("You're Welcome");
            }
            else
            {
                Console.WriteLine("Sorry, I didn't understand that. Please type 'go', 'headache', 'stomachache', or 'exit'.");
            }
        }
    }

    public void ProvideHealthAdvice(string issue)
    {
        if (issue == "headache")
        {
            Console.WriteLine(
                "1. Stay Hydrated: Drink water, as dehydration is a common cause of headaches.\n" +
                "2. Rest: Take a break and relax in a quiet, dark room.\n" +
                "3. Apply a Cold or Warm Compress: Place a cold compress on your forehead or a warm one on your neck or back.\n" +
                "4. Massage: Gently massage your temples, neck, or shoulders to relieve tension.\n" +
                "5. Manage Stress: Practice deep breathing or relaxation techniques.\n" +
                "6. Pain Relief Medication: Use over-the-counter pain relievers like ibuprofen or acetaminophen.");
        }
        else if (issue == "stomachache")
        {
            Console.WriteLine(
                "1. Drink Water: Stay hydrated, but sip slowly.\n" +
                "2. Eat Light: Stick to bland foods like crackers, bananas, or rice if you're hungry.\n" +
                "3. Ginger or Peppermint: Drinking ginger tea or sucking on peppermint candy can help soothe your stomach.\n" +
                "4. Avoid Caffeine and Fatty Foods: These can irritate the stomach further.\n" +
                "5. Rest: Lie down and relax, but avoid lying flat; prop yourself up slightly.\n" +
                "6. Use a Heating Pad: Place it on your stomach to relieve cramps or discomfort.");
        }
    }

    public void SetExerciseGoal(string exerciseType, int goal)
    {
        // Placeholder for future functionality
        return;
    }
}

class Program
{
    static void Main(string[] args)
    {
        Chatbot chatbot = new Chatbot();
        chatbot.Start();
    }
}
