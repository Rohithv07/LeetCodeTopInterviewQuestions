class Solution:
    def licenseKeyFormatting(self, S: str, K: int) -> str:
        newS = S.upper().replace('-','')[::-1]
        result = ('-'.join([(newS[pos:pos+K]) for pos in range(0, len(newS), K)]))
        return result[::-1]
