This question is asked by Google. Email addresses are made up of local and domain names. For example in kevin@dailybyte.com, kevin is the local name and dailybye.com is the domain name. Email addresses may also contain '+' or '.' characters besides lowercase letters. If there is a '.' in the local name of the email address it is ignored. Everything after a '+' in the local name is also ignored. For example ke.vin+abc@dailybyte.com is equivalent to kevin@dailybyte.com Given a list of email addresses, find the number of unique addresses.

Ex: Given the following emails...

emails = [
    "test.email+kevin@dailybyte.com", 
    "test.e.mail+john.smith@dailybyte.com", 
    "testemail+david@daily.byte.com"
], return 2. "testemail@dailybyte.com" and "testemail@daily.byte.com" are unique since the first two email addresses in the list are equivalent.



class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String [] arrayEmail = email.split("@");
            String localPart = arrayEmail[0];
            String domainPart = arrayEmail[1];
            for (int i=0; i<localPart.length(); i++) {
                if (localPart.charAt(i) == '+') {
                    localPart = localPart.substring(0, i);
                    break;
                }
            }
            StringBuffer sb = new StringBuffer();
            sb.append(localPart.replace(".", ""));
            sb.append("@");
            sb.append(domainPart);
            set.add(sb.toString());
        }
        return set.size();
    }
}
