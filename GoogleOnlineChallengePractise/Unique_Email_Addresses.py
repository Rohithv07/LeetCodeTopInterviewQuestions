class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        visited = set()
        for email in emails:
            localPart, domainName = email.split('@')
            if '+' in localPart:
                localPart = localPart[:localPart.index('+')]
            visited.add(localPart.replace('.', '') + '@' + domainName)
                
        return len(visited)
