#include <iostream>
#include <set>
#include <vector>

using namespace std;

/**
 * Problem: Concert Tickets
 * Strategy: Use a multiset to store ticket prices. Use upper_bound 
 * to find the first price > maxPrice, then decrement the iterator 
 * to find the largest price <= maxPrice.
 * 
 * // using this as the java solution is TLE
 */

int main() {
    // Fast I/O: Equivalent to the FastReader in Java
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    if (!(cin >> n >> m)) return 0;

    multiset<int> tickets;
    for (int i = 0; i < n; i++) {
        int price;
        cin >> price;
        tickets.insert(price);
    }

    for (int i = 0; i < m; i++) {
        int maxPrice;
        cin >> maxPrice;

        // upper_bound returns an iterator to the first element STRICTLY GREATER than maxPrice
        auto it = tickets.upper_bound(maxPrice);

        // If the iterator is at the beginning, it means all tickets are > maxPrice
        if (it == tickets.begin()) {
            cout << -1 << "\n";
        } else {
            // Step back one position to get the largest element <= maxPrice
            --it;
            cout << *it << "\n";
            
            // Remove ONLY the specific instance pointed to by the iterator
            tickets.erase(it);
        }
    }

    return 0;
}