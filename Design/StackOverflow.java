// so lets start with the very base class, User

class User {
	int userId;
	Search searchObject;

	List<Question> getAllQuestions(String searchQuestion);
}


// now we will be having a member who is a user

class Member extends User {
	Account account;
	List<Badge> badges;

	public void askQuestion(Question question);
	public void answerAQuestion(Question question, Answer answer);
	public void vote(Entity entity, VoteType voteType);
	public void flag(Entity entity);
	public void addComment(Comment comment, Entity entity);
	// here entity means like the registered user can add a comment to a question, an answer or the same comment. So thats entity
	public List<Badge> getAllBadges();
	public void addTag(Tag tag, Entity entity);
}

class Account {
	int accountId;
	String userName;
	String email;
	String password;
	String bioDescription;
	String linksToSites;
	Address address;
	AccountStatus accountStatus;
	int reputation;
}

class Moderator extends Member {
	public Boolean closeAQuestion(Question question);
	public Boolean reopenQuestion(Question question);
}

class Admin extends Member {
	public Boolean blockMember(Member member);
	public Boolean unBlockMember(Member member);
}

public enum AccountStatus {
	BLOCKED, ACTIVE, INACTIVE;
}

public enum VoteType {
	UPVOTE, DOWNVOTE;
}

class Badge {
	String badgeName;
	String badgeDescription;
}

public class Entity {
	int entityId;
	Member member;
	Map<VoteType, Integer> voteCount;
	List<Comment> comment;
	Date createdDate;

	public boolean flagEntity(Member member);
	public boolean voteEntity(VoteType voteType);
	public boolean addComment(Comment comment);
}

public class Comment extends Entity {
	String message;
}

public class Question extends Entity {
	// so typically when we ask a question, there can be a list of edits that we might be doing
	// there can be different tags we provide
	// there can be title, description for the question
	// there can be several answers given by the users
	List<EditHistory> editHistoryList;
	List<Tags> tagsList;
	List<Answer> answerList;
	String title;
	String description;
	QuestionStatus questionStatus;

	public boolean addTag(Tag tag);
	public boolean addQuestion(Question question);

}

public class Answer extends entity {
	String answer;
	Boolean accepted;
	public boolean addAnswer(Answer answer);
}

public enum QuestionStatus {
	ACTIVE, CLOSED;
}

public class Tag {
	String name;
	String description;
}

public class EditHistory {
	int editHistoryId;
	Member memberEdited;
	Date dateOfEdit;
	Question previousQuestion;
	Question afterEditQuestion;
}
