package practice.dev.problemsolving.dreams11.teamformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 
 * @author dev
 *
	Assumptions made :
 		-> (Number Of Teams * Total Number of Members Per Team ) <= Total Number Of Players Pool
 		-> Pool of All rounders = Intersection of (Pool of Batsman) and (Pool of Bowlers) 
 		
 	Notes :
		-> Validations on adherence to constraints of input values are not performed so It'll only work on Positive Cases i.e only work on right inputs based on constraints
		
 Detailed Problem is Given Here :

************************************** Start : Problem statement *******************************************

Dream11 hosts various fantasy matches based on real life sport event. Every time when there is a cricket match between two teams, Dream11 faces challenge of creating teams of equal strength (which is just the summation of strength in individual player of each team).

For Every cricket match played between 2 teams, there are total N players from both team. 

Array a,b,c represents batsman,bowlers,wicket keepers  respectively among N players 

Array S represents strenght of each Player among N players

Dream11's Objective is create TWO teams that are STRONGEST (having maximum total strength) with minimum difference in their Strength with following conditions:

x - maximum no of batsman in any team.

y - maximum no of bowlers in any team.

z - maximum no of wicket keepers in any team.

al- maximum no of All rounders in any team. All rounders are players fall within intersection of a,b array.

N - No of Players 

m - No of batsman in N

a - array representing batsman among N.

o - No of Bowlers in N 

b - array representing bowlers among N.

p - No of wicket keepers 

c - array representing wicket keepers among N.

x,y,z,al

k - no of Players each team must have .

S- Strength of each players 



Input Example 

N- 8 

players Array PL- [1,2,3,4,5,6,7,8] -- Consider 8 players

m- 4 

a- [2,3,4,5]   -- where 2,3,5 are batsman from players Array

o- 3-

b- [1,4,6]  -- where 1,4,6 are bowlers from players Array

p- 2

c- [7,8]     -- where 7,8 are wicket keepers from players Array

x- 2

y- 2

z-1

al- 1

k- 5 

S- [45,63,23,56,23,46,23,25]     -- Strength of each players 





Strength of Batsman from Array a can be Given by S[a[i]]

Strength of Bowlers from Array b can be Given by S[b[i]]

Strength of Wicket Keepers from Array c can be Given by S[c[i]]

Strength of Each Players can be Given by S[PL[i]]



Output: 

T1,T2,S1,S2,D

T1 - array of players in team1 

T2 - array of players in team2 

S1 - total strength of team1

S2 - total strength of team2

D = |S1-S2| Where D should be minimum



************************************** End : Problem statement *******************************************

 */
public class TeamFormation {
	
	enum TeamComparativeStrengthStrategy {
		MIN, //If this is the strategy then Always strive for team strength difference value to reach to Zero (0), while allocating players to teams.
		MAX; //If this is the strategy then Always strive for team strength difference value to reach to maximum than the value at previous allocation, while allocating players to teams.
	}
	
	enum TeamFormationStates {
		NOT_FORMED,
		BUILDING,
		FORMED;
	}
	
	enum PlayerFunctionalType {
		BATSMAN,
		BOWLER,
		WICKET_KEEPER, 
		ALLROUNDER;
	}
	
	class Team {
		
		@Override
		public String toString() {
			return "Team [id=" + id + ", teamFormationState=" + teamFormationState 
					+ ", presentTotalMembers=" + presentTotalMembers + ", strength=" + strength 
					+ ", bats=" + bats + ", keeps=" + keeps + ", alls=" + alls
					+ ", bowls=" + bowls
					+ "]";
		}
		public Team(Integer id) {
			this.id = id;
		}
		Integer id;
		List<Player> alls,bats,bowls,keeps;
		Integer presentTotalMembers = 0; 
		Integer strength = 0;
		TeamFormationStates teamFormationState = TeamFormationStates.NOT_FORMED;
	}
	
	class Player implements Comparable<Player> {
		
		@Override
		public String toString() {
			return "Player [id=" + id 
					+ ", functionalType=" + functionalType
					+ ", strength=" + strength
					+ "]";
		}

		Integer id;
		Integer strength;
		PlayerFunctionalType functionalType;
		
		public Player(Integer id, Integer strength, PlayerFunctionalType functionalType) {
			this.id = id;
			this.strength = strength;
			this.functionalType = functionalType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + id;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Player other = (Player) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id != other.id)
				return false;
			return true;
		}
		
		private TeamFormation getOuterType() {
			return TeamFormation.this;
		}

		@Override
		public int compareTo(Player o) {
			return this.id.compareTo(o.id);
		}
		
	}
	
	private int N,m,o,p,x,y,z,al,k;
	private List<Integer> PL,a,b,c,S,allrounders;
	private List<Team> teams;
	private List<Player> players;
	private TeamComparativeStrengthStrategy teamComparativeStrengthStrategy;//depending on the TeamComparativeStrengthStrategy, always choose the Min or Max value of it among all individual team allocation processes
	private int strengthDiff = 0;
	
	/**
	 * By default it creates 2 teams with TeamComparativeStrengthStrategy.MIN
	 */
	public TeamFormation() {
		this(2, TeamComparativeStrengthStrategy.MIN);
	}
	
	public TeamFormation(int numOfTeams, TeamComparativeStrengthStrategy teamComparativeStrengthStrategy) {
		this.teams = new ArrayList<TeamFormation.Team>(numOfTeams);
		for(int i = 0; i < numOfTeams; ++i) {
			this.teams.add(new Team(i));
		}
		this.players = new ArrayList<>();
		this.teamComparativeStrengthStrategy = teamComparativeStrengthStrategy;
	}
	
	/**
	 * It's main function that should be called to execute the programme
	 * @param args
	 * @throws Exception
	 */
	public static void main(String [] args) throws Exception {
		//By default it creates 2 teams with TeamComparativeStrengthStrategy.MIN
		TeamFormation tf = new TeamFormation();
		tf.populateInputDataInteractively();
		tf.formTeam();
		tf.printOutput();
	}
	
	/**
	 * Throws exception if input is empty or length is less than 3 or not of right format. example in = [1] or in = [1,2] is valid
	 * 
	 * @param in
	 * @param split
	 * @param outputArrayLength
	 * @return
	 * @throws Exception
	 */
	public List<Integer> parseArray(String in, String split, int outputArrayLength) throws Exception {
		List<Integer> temp = new ArrayList<>();
		if(in == null || in.isEmpty() || in.length() < 3) {
			throw new Exception("Invalid Input");
		} else {
			if(in.length() == 3) {
				temp.add(Integer.parseInt(in.substring(1,2)));
			} else {
				String[] strTemp = in.split(split);
				if(outputArrayLength != strTemp.length) {
					throw new Exception("Invalid Input");
				}
				int lastIndex = strTemp.length - 1;
				for(int i = 0; i <= lastIndex; ++i) {
					if(i == 0) {
						temp.add(Integer.parseInt(strTemp[i].substring(1)));
					} else if(i == (lastIndex)) {
						temp.add(Integer.parseInt(strTemp[i].substring(0,(strTemp[i].length() - 1))));
					} else {
						temp.add(Integer.parseInt(strTemp[i]));
					}
				}
			}
		}
		return temp;
	}
	
	/**
	 * It asks for input and parse it to respective member fields of the object
	 */
	private void populateInputDataInteractively() {
		String regexpStr = "(\\[([0-9]+,?)+\\])";
		Pattern regexp = Pattern.compile(regexpStr);
	    Scanner scanner = new Scanner(System.in);
		String strTempArr;
		
		try {
			System.out.println("************ Start : Please provide input as asked *****************************\n");
			
			System.out.println("No of Players (N)- ");
			this.N =  scanner.nextInt();
			
			System.out.println("Players are (PL)- ");
			//this.PL = new int[this.N];
			//System.out.println(this.PL.length);
			strTempArr = scanner.next(regexp);
			this.PL = this.parseArray(strTempArr, ",", this.N);
			System.out.println(this.PL);
			
			System.out.println("No of Batsman in N (m)- ");
			this.m =  scanner.nextInt();
			
			System.out.println("Batsman are (a)- ");
			//this.a = new int[this.m];
			//System.out.println(this.a.length);
			strTempArr = scanner.next(regexp);
			this.a = this.parseArray(strTempArr, ",", this.m);
			System.out.println(this.a);
			
			System.out.println("No of Bowlers in N (o)- ");
			this.o =  scanner.nextInt();
			
			System.out.println("Bowlers are (b)- ");
			//this.b = new int[this.o];
			//System.out.println(this.b.length);
			strTempArr = scanner.next(regexp);
			this.b = this.parseArray(strTempArr, ",", this.o);
			System.out.println(this.b);
			
			System.out.println("No of Wicketkeepers (p)- ");
			this.p =  scanner.nextInt();
			
			System.out.println("Wicketkeeprs are (c)- ");
			//this.c = new int[this.p];
			//System.out.println(this.c.length);
			strTempArr = scanner.next(regexp);
			this.c = this.parseArray(strTempArr, ",", this.p);
			System.out.println(this.c);
			
			System.out.println("Maximum no of batsman in any team (x)- ");
			this.x =  scanner.nextInt();
			
			System.out.println("Maximum no of bowlers in any team (y)- ");
			this.y =  scanner.nextInt();
			
			System.out.println("Maximum no of wicketkeepers in any team (z)- ");
			this.z =  scanner.nextInt();
			
			System.out.println("Maximum no of allrounders in any team (al)- ");
			this.al =  scanner.nextInt();
			
			System.out.println("No of players each team must have (k)- ");
			this.k =  scanner.nextInt();
			
			System.out.println("Strength of each players (S)- ");
			//this.S = new int[this.N];
			//System.out.println(this.S.length);
			strTempArr = scanner.next(regexp);
			this.S = this.parseArray(strTempArr, ",", this.N);
			System.out.println(this.S);
			
			System.out.println("\n************ End : Please provide input as asked *****************************\n\n");
		} catch(Exception e) {
			System.out.println("Can't execute the prgramme : Invalid input encountered while parsing given input");
		}
		scanner.close();
		this.allrounders = findAllrounders(this.a, this.b);//It'll contain intersection of players present as batsman and bowlers without removing players from those categories
		prepareTeams();
		preparePlayers();
	}
	
	private void prepareTeams() {
		List<Player> temp;
		for(Team t : this.teams) {
			temp  = new ArrayList<>(this.al);
			t.alls = temp;
			temp  = new ArrayList<>(this.x);
			t.bats = temp;
			temp  = new ArrayList<>(this.y);
			t.bowls = temp;
			temp  = new ArrayList<>(this.z);
			t.keeps = temp;
			t.teamFormationState = TeamFormationStates.BUILDING;
		}
	}

	/**
	 * Prepare all Players with their Id and Strength
	 */
	private void preparePlayers() {
		Player p;
		List<Player> pl = new ArrayList<>();
		int i = 0;
		PlayerFunctionalType pft = null;
		while(i < this.PL.size()) {
			if(this.allrounders.contains(this.PL.get(i))) {
				pft = PlayerFunctionalType.ALLROUNDER;
			} else if(this.a.contains(this.PL.get(i))) {
				pft = PlayerFunctionalType.BATSMAN;
			} else if(this.b.contains(this.PL.get(i))) {
				pft = PlayerFunctionalType.BOWLER;
			} else if(this.c.contains(this.PL.get(i))) {
				pft = PlayerFunctionalType.WICKET_KEEPER;
			}
			p = new Player(this.PL.get(i), this.S.get(i), pft);
			pl.add(p);
			++i;
		}
		this.players = Collections.unmodifiableList(pl);//So that we can predictably search for the player index same as this.N index order and their strength
	}

	private List<Integer> findAllrounders(final List<Integer> batsman, final List<Integer> bowlers) {
		List<Integer> ar = new ArrayList<>();
		for(Integer i : batsman) {
			if(bowlers.contains(i)) {
				ar.add(i);
			}
		}
		return ar;
	}

	public void printOutput() {
		System.out.println("\n************ Start : Output *****************************\n\n");
		for(Team t : this.teams) {
			System.out.print("T" + t.id + " - ");
			for(Player p : t.bats) {
				System.out.print(p.id + ", ");
			}
			for(Player p : t.keeps) {
				System.out.print(p.id + ", ");
			}
			for(Player p : t.alls) {
				System.out.print(p.id + ", ");
			}
			for(Player p : t.bowls) {
				System.out.print(p.id + ", ");
			}
			System.out.println();
		}
		for(Team t : this.teams) {
			System.out.println("S" + t.id + " - " + t.strength);
		}
		System.out.println("D = " + this.strengthDiff);
		System.out.println("\n************ End : Output *****************************\n\n");
	}

	/**
	 * This has logic to create teams with all constraints provided by the user.
	 */
	private void formTeam() {
		
		int idx = 0, 
				teamIndexFromStart = 0, teamIndexFromEnd = (this.teams.size() - 1), 
				teamIndex = 0, lastTeamVisitedIndex = 0, 
				teamIndexStrength = 0, lastTeamVisitedIndexStrength = 0, 
				tempStrengthDiff = 0, countOfTeamNotFormed = this.teams.size();
		boolean playerAllocated = false;
		PlayerFunctionalType pft;
		List<Player> playersWithDescendingOrderOfStrength = new ArrayList<>(this.players);//it will store the players in descending order of the strength i.e. from high to low
		
		Collections.sort(playersWithDescendingOrderOfStrength, new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
				return o2.strength.compareTo(o1.strength);
			}
		});// it will sort the players in descending order of their strength
		
		System.out.println(playersWithDescendingOrderOfStrength);
		
		if(this.teamComparativeStrengthStrategy == TeamComparativeStrengthStrategy.MIN) {
			
			while(idx < playersWithDescendingOrderOfStrength.size() && countOfTeamNotFormed > 0) {
				
				pft = playersWithDescendingOrderOfStrength.get(idx).functionalType;
				
				if(!isTeamFormed(this.teams.get(teamIndex))) {
					
					lastTeamVisitedIndexStrength = this.teams.get(lastTeamVisitedIndex).strength;
					teamIndexStrength = this.teams.get(teamIndex).strength;
					tempStrengthDiff = (lastTeamVisitedIndexStrength - teamIndexStrength);
					if(playerAllocated && (tempStrengthDiff < 0)) {
						teamIndex = lastTeamVisitedIndex;
					}
					
					switch(pft) {
						case ALLROUNDER : 
							if(constraintAdherence(this.teams.get(teamIndex), PlayerFunctionalType.ALLROUNDER)) {
								this.teams.get(teamIndex).alls.add(playersWithDescendingOrderOfStrength.get(idx));
								this.teams.get(teamIndex).strength += (playersWithDescendingOrderOfStrength.get(idx).strength);
								this.teams.get(teamIndex).presentTotalMembers++;
								playerAllocated = true;
							} else {
								playerAllocated = false;
							}
							break;
						case BATSMAN : 
							if(constraintAdherence(this.teams.get(teamIndex), PlayerFunctionalType.BATSMAN)) {
								this.teams.get(teamIndex).bats.add(playersWithDescendingOrderOfStrength.get(idx));
								this.teams.get(teamIndex).strength += (playersWithDescendingOrderOfStrength.get(idx).strength);
								this.teams.get(teamIndex).presentTotalMembers++;
								playerAllocated = true;
							} else {
								playerAllocated = false;
							}
							break;
						case BOWLER : 
							if(constraintAdherence(this.teams.get(teamIndex), PlayerFunctionalType.BOWLER)) {
								this.teams.get(teamIndex).bowls.add(playersWithDescendingOrderOfStrength.get(idx));
								this.teams.get(teamIndex).strength += (playersWithDescendingOrderOfStrength.get(idx).strength);
								this.teams.get(teamIndex).presentTotalMembers++;
								playerAllocated = true;
							} else {
								playerAllocated = false;
							}
							break;
						case WICKET_KEEPER : 
							if(constraintAdherence(this.teams.get(teamIndex), PlayerFunctionalType.WICKET_KEEPER)) {
								this.teams.get(teamIndex).keeps.add(playersWithDescendingOrderOfStrength.get(idx));
								this.teams.get(teamIndex).strength += (playersWithDescendingOrderOfStrength.get(idx).strength);
								this.teams.get(teamIndex).presentTotalMembers++;
								playerAllocated = true;
							} else {
								playerAllocated = false;
							}
							break;
						default : break;
					}
					
				} else {
					playerAllocated = false;
					--countOfTeamNotFormed;
				}
				
				//keep track of last team index visited
				lastTeamVisitedIndex = teamIndex;
				
				//Here we are choosing the teams in round-robin fashion i.e. from start to end sequentially and then again cycle
				teamIndex = ((teamIndex + 1) % this.teams.size());  
				
				/*//Alternate Logic, if we don't want to use above round-robin pattern: For Distribution of Players from both ends on alternate execution of the loop
				if((teamIndexFromStart < this.teams.size()) && (teamIndexFromEnd >= 0)) {
					if(teamIndex == teamIndexFromStart) {
						teamIndex = teamIndexFromEnd;
						teamIndexFromStart++;
					} else {
						teamIndex = teamIndexFromStart;
						teamIndexFromEnd--;
					}
				}*/
				
				//increment playersWithDescendingOrderOfStrength index only when the player picked from it is allocated to a team
				if(playerAllocated) {
					this.strengthDiff = Math.abs(this.strengthDiff - playersWithDescendingOrderOfStrength.get(idx).strength);
					++idx;
				}
				
			}//End of While Loop
			
		} else {
			
			//TODO: This is for TeamComparativeStrengthStrategy.MAX strategy which we are not implementing at the moment as it'll be hardly used and also not required at the moment
			
		}// End of Outermost if-else block
	}

	private boolean isTeamFormed(Team team) {
		boolean isFormed = false;
		if(team.presentTotalMembers >= this.k) {
			team.teamFormationState = TeamFormationStates.FORMED;
			isFormed = true;
		}
		return isFormed;
	}

	private boolean constraintAdherence(Team team, PlayerFunctionalType pft) {
		boolean adherencePassed = false;
		switch(pft) {
			case ALLROUNDER : 
				if(team.alls.size() < this.al) {
					adherencePassed = true;
				} else {
					adherencePassed = false;
				}
				break;
			case BATSMAN : 
				if(team.bats.size() < this.x) {
					adherencePassed = true;
				} else {
					adherencePassed = false;
				}
				break;
			case BOWLER : 
				if(team.bowls.size() < this.y) {
					adherencePassed = true;
				} else {
					adherencePassed = false;
				}
				break;
			case WICKET_KEEPER : 
				if(team.keeps.size() < this.z) {
					adherencePassed = true;
				} else {
					adherencePassed = false;
				}
				break;
			default :
				adherencePassed = true;
		}
		return adherencePassed;
	}
	
}
