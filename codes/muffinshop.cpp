#include <iostream>
#include <string>
using namespace std;

class MenuItem {
public:
    string name;
    double price;
    int quantity;

    MenuItem(string n, double p) {
        name = n;
        price = p;
        quantity = 0;
    }
};

int main() {
    const int NUM_ITEMS = 7;
    double tax_rate = 0.05;
    double subtotal = 0.0, tax = 0.0, total = 0.0;
    MenuItem menu[NUM_ITEMS] = {
        MenuItem("Plain Egg", 1.45),
        MenuItem("Bacon and Egg", 2.45),
        MenuItem("Muffin", 0.99),
        MenuItem("French Toast", 1.99),
        MenuItem("Fruit Basket", 2.49),
        MenuItem("Cereal", 0.69),
        MenuItem("Coffee", 0.50)
    };

    cout << "Welcome to the restaurant!" << endl;
    cout << "Here is the menu for the day:" << endl;

    for (int i = 0; i < NUM_ITEMS; i++) {
        cout << menu[i].name << " - $" << menu[i].price << endl;
    }

    char input;
    do {
        cout << endl << "What would you like to order? Enter the corresponding number or 'q' to quit:" << endl;
        for (int i = 0; i < NUM_ITEMS; i++) {
            cout << (i+1) << ". " << menu[i].name << " ($" << menu[i].price << ")" << endl;
        }
        cin >> input;

        if (isdigit(input)) {
            int choice = input - '0';
            if (choice >= 1 && choice <= NUM_ITEMS) {
                cout << "How many " << menu[choice-1].name << " would you like to order?" << endl;
                int quantity;
                cin >> quantity;
                menu[choice-1].quantity += quantity;
                cout << "Added " << quantity << " " << menu[choice-1].name << "(s) to your order." << endl;
            }
        }
    } while (input != 'q');

    cout << endl << "Here is your order:" << endl;
    for (int i = 0; i < NUM_ITEMS; i++) {
        if (menu[i].quantity > 0) {
            cout << menu[i].name << " - " << menu[i].quantity << " x $" << menu[i].price << " = $" << (menu[i].quantity * menu[i].price) << endl;
            subtotal += menu[i].quantity * menu[i].price;
        }
    }

    tax = subtotal * tax_rate;
    total = subtotal + tax;

    cout << "Subtotal: $" << subtotal << endl;
    cout << "Tax (5%): $" << tax << endl;
    cout << "Total: $" << total << endl;

    return 0;
}