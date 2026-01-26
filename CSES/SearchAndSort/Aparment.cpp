#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath> // For std::abs, although not strictly needed here

using namespace std;

// Function to find the maximum number of applicants who get an apartment
// doing this as Java is TLE
int findTotalApartment(vector<long long>& applicant, vector<long long>& apartment, long long k) {
    
    // Step 1: Sort both vectors (Crucial for the Two-Pointer Greedy approach)
    sort(applicant.begin(), applicant.end());
    sort(apartment.begin(), apartment.end());
    
    int p1 = 0; // Pointer for applicants
    int p2 = 0; // Pointer for apartments
    int count = 0; // Counter for successful allocations

    // Step 2: Two-Pointer Iteration
    // We iterate while both pointers are within the bounds of their respective vectors
    while (p1 < applicant.size() && p2 < apartment.size()) {
        long long applicantSize = applicant[p1];
        long long apartmentSize = apartment[p2];

        // Define the acceptable range for the current applicant
        // Note: Using long long for k and sizes prevents potential overflow during calculations
        long long minSize = applicantSize - k;
        long long maxSize = applicantSize + k;
        
        // Case 1: Match Found (Apartment size is within the required range)
        if (apartmentSize >= minSize && apartmentSize <= maxSize) {
            // Successful match: Increment count and move both pointers
            count++;
            p1++; // Applicant p1 is served
            p2++; // Apartment p2 is used
        }
        
        // Case 2: Apartment is Too Small (Apartment size is less than the minimum required)
        else if (apartmentSize < minSize) {
            // This apartment is too small for applicant p1, and since lists are sorted,
            // it will also be too small for subsequent (larger) applicants.
            // Discard this apartment and move to the next one.
            p2++;
        }
        
        // Case 3: Apartment is Too Large (Apartment size is greater than the maximum required)
        else { // apartmentSize > maxSize
            // This apartment is too large for applicant p1. 
            // We must keep the apartment (p2) for the next, potentially larger, applicant.
            // Discard this applicant and move to the next one.
            p1++;
        }
    }
    
    return count;
}

int main() {
    // Fast I/O for competitive programming
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long n, m, k;
    
    // Read n, m, k. Using long long for k and sizes to respect the constraint 10^9
    if (!(cin >> n >> m >> k)) return 0;
    
    // Read applicant desired sizes
    vector<long long> applicant(n);
    for (int i = 0; i < n; i++) {
        cin >> applicant[i];
    }
    
    // Read apartment actual sizes
    vector<long long> apartment(m);
    for (int i = 0; i < m; i++) {
        cin >> apartment[i];
    }
    
    // Call the solver function and print the result
    cout << findTotalApartment(applicant, apartment, k) << "\n";
    
    return 0;
}