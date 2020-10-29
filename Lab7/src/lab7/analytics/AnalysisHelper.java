/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    // find user with Most Likes
    // TODO
    
    //1
    public void avgLikesPerComment() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        double numberOfLikes = 0;
        int numberOfComments = 0;
        for (Post post : posts.values()) {
            for (Comment c : post.getComments()) {
                numberOfLikes += c.getLikes();
                numberOfComments += 1;
            }
        }
        double avgLikes = numberOfLikes / numberOfComments;
        System.out.println("\nQ1:\nAverage number of likes per comment:" + avgLikes + "\n");
    }

    public void postWithMaxLikes() {
        Map<Integer, Integer> postLikecount = new HashMap<Integer, Integer>();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer,Integer> likeList = new HashMap<>();
        for (Post post : posts.values()) {
            for (Comment c : post.getComments()) {
                
            }

        }

        int max = 0;
        int maxId = 0;
        for (int id : postLikecount.keySet()) {
            if (postLikecount.get(id) > max) {
                max = postLikecount.get(id);
                maxId = id;
            }
        }
        System.out.println("\nQ4:The post with maximum liked comments is:\n" + "Post Id:" + max + "\n");
    }

    //5
    public void inactiveUsersWithLeastComment() {
        Map<Integer, Integer> userCommentcount = new HashMap<Integer, Integer>();
        Map<Integer, User> userMap = DataStore.getInstance().getUsers();

        List<User> userList = new ArrayList(userMap.values());
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                //so as to get descending list
                return u1.getComments().size() - u2.getComments().size();
            }
        });
        System.out.println("\nQ5:\nThe 5 most inactive Users based on comments:");
        for (int i = 0; i < userList.size() && i < 5; i++) {
            System.out.println("User ID:" + userList.get(i).getId());
        }
    }

    //6
    public void top5InactiveUsersOverall() {
        Map<Integer, User> userMap = DataStore.getInstance().getUsers();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, Integer> newUserMap = new HashMap<>();
        for (User user : userMap.values()) {
            newUserMap.put(user.getId(), user.getComments().size());
            for (Comment comment : user.getComments()) {
                newUserMap.put(user.getId(), newUserMap.get(user.getId()) + comment.getLikes());
            }

            for (Post post : posts.values()) {
                newUserMap.put(post.getUserId(), (post.getUserId()) + 1);
            }
            List<Map.Entry<Integer, Integer>> list = new LinkedList<>(newUserMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });
            HashMap<Integer, Integer> temp = new LinkedHashMap<>();
            for (Map.Entry<Integer, Integer> aa : list) {
                temp.put(aa.getKey(), aa.getValue());
            }
            System.out.println("\nQ6:\nTop 5 inactive users on the basis of posts, likes and comments:");
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                if (count >= 5) {
                    return;
                }
                System.out.println("User Id = " + entry.getKey() + " Sum Of post, likes and comments = " + entry.getValue());
                count++;
            }
        }
    }

    //7
    public void top5ProactiveUsersOverall() {
        Map<Integer, User> userMap = DataStore.getInstance().getUsers();
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, Integer> newUserMap = new HashMap<>();
        for (User user : userMap.values()) {
            newUserMap.put(user.getId(), user.getComments().size());
            for (Comment comment : user.getComments()) {
                newUserMap.put(user.getId(), newUserMap.get(user.getId()) + comment.getLikes());
            }
        }
        for (Post post : posts.values()) {
            newUserMap.put(post.getUserId(), (post.getUserId()) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(newUserMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        HashMap<Integer, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        System.out.println("\nQ7:\nTop 5 proactive users by posts, comments and likes:");
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            if (count >= 5) {
                return;
            }
            System.out.println("User Id = " + entry.getKey() + " Sum of post, likes and comments = " + entry.getValue());
            count++;
        }
    }
     
     
 //3  
    public void postWithMostComments() {
        
     Map<Integer , Integer> noofcomments = new HashMap<Integer , Integer>();
 
     
     System.out.println("\nQ3:");
     
     for (Post post : DataStore.getInstance().getPosts().values()) {
         noofcomments.put(post.getPostId(), post.getComments().size());
     }
     
     int keyPost = Collections.max(noofcomments.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
     int commentPost = noofcomments.get(keyPost);
     
     for (Map.Entry<Integer , Integer> entry : noofcomments.entrySet()) {
         
         if (entry.getValue() == commentPost ) {
         System.out.println("Post ID is  "+ entry.getKey() + " No of comments " + entry.getValue());
         
         }
     
     
     }
     
     }
  // 4    
        public void topInactiveWithTotalPost() {
        
        System.out.println("\nQ4:");
    
    Map<Integer, Post> posts =  DataStore.getInstance().getPosts() ;
    Map<Integer, User> user =  DataStore.getInstance().getUsers() ;
     Map<Integer , Integer> noOfPosts = new HashMap<>();
    
    for (Post post : posts.values()) {
        
        if (noOfPosts.containsKey(post.getUserId())) {
        
        noOfPosts.replace(post.getUserId(), noOfPosts.get(post.getUserId()) + 1) ;
        }
        else {
             noOfPosts.put(post.getUserId(),1);
        }
    }          
          Map<Integer, Integer> result1 = noOfPosts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
          
   int count  = 0 ; 
    for (Map.Entry<Integer, Integer> entry : result1.entrySet()) {
           if (count >= 5) {
               return;
           }
           
           System.out.println("User Id = " + entry.getKey() + "  " + user.get(entry.getKey()) +" Total Post = " + entry.getValue());
           count++;
       }
     
    }
 //2       
            public void postWithMostLikes() {

        Map<Integer, Integer> likesList = new HashMap<Integer, Integer>();
        Map<Integer, Post> posts11 =  DataStore.getInstance().getPosts() ;
        int finalLike = 0;

          System.out.println("\nQ2:");

        for (Post post : DataStore.getInstance().getPosts().values()) {
            for (Comment comm : post.getComments()) {

                if (comm.getLikes() > finalLike) {

                    finalLike = comm.getLikes();

                }

            }

            likesList.put(post.getPostId(), finalLike);
            finalLike = 0;
        }
        
    
        
         Map<Integer, Integer> result1 = likesList.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        
         
         int count  = 0 ; 
    for (Map.Entry<Integer, Integer> entry : result1.entrySet()) {
           if (count >= 1) {
               return;
           }
           
           System.out.println("Post Id = " + entry.getKey() + "  "  +" Likes Number " + entry.getValue());
           System.out.println("Posting User Id = " + posts11.get(entry.getKey()).getUserId() );
           System.out.println("Comment are " + posts11.get(entry.getKey()).getComments() );
           count++;
       }
        

    }
}
