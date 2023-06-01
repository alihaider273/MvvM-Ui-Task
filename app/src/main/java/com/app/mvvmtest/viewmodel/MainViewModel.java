package com.app.mvvmtest.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//import com.jadgroup.recyclerviewlivedata.model.User;

import com.app.mvvmtest.model.Post;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    MutableLiveData<ArrayList<Post>> userLiveData;
    ArrayList<Post> postArrayList;

    public MainViewModel() {
        userLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<Post>> getUserMutableLiveData() {
        return userLiveData;
    }

    public void init() {
        populateList();
        userLiveData.setValue(postArrayList);
    }

    private List<String> populateCommentList() {
        List<String> comments = new ArrayList<>();
        comments.add("어머 제가 있던 팬이블이 제일 반응이 좋았나보네요 우짤래미님도 아시겠지만 저도 일반인 몸매 그 이상도 이하도 아니잖아요?! 그런 제가 기꺼이 도전해봤는데 생각보다 괜찮았어요! 오늘 중으로 라이브 리뷰 올라온다고 하니 꼭 봐주세용~!");
        comments.add("어머 제가 있던 팬이블이 제일 ");
        return comments;
    }

    private List<String> populateTagsList() {
        List<String> tags = new ArrayList<>();
        tags.add("#2023");
        tags.add("#TODAY");
        tags.add("#TOP");
        tags.add("#POPS!");
        tags.add("#WOW");
        tags.add("#ROW");
        return tags;
    }

    public void populateList() {
        Post post = new Post();
        post.setTitle("지난 월요일에 했던 이벤트 중 가장 괜찮은 상품 뭐야?");
        post.setDescription("지난 월요일에 2023년 S/S 트렌드 알아보기 이벤트 참석했던 팝들아~혹시 어떤 상품이 제일 괜찮았어?\n\n후기 올라오는거 보면 로우라이즈? 그게 제일 반응 좋고 그 테이블이제일 재밌었다던데 맞아???\n\n올해 로우라이즈가 트렌드라길래 나도 도전해보고 싶은데 말라깽이가아닌 사람들도 잘 어울릴지 너무너무 궁금해ㅜㅜ로우라이즈 테이블에있었던 팝들 있으면 어땠는지 후기 좀 공유해주라~~!");
        post.setImgIcon("https://wjddnjs754.cafe24.com/web/product/small/202303/5b9279582db2a92beb8db29fa1512ee9.jpg");
        post.setTags(populateTagsList());
        post.setComments(populateCommentList());
        postArrayList = new ArrayList<>();
        postArrayList.add(post);
        postArrayList.add(post);
        postArrayList.add(post);
        postArrayList.add(post);
        postArrayList.add(post);
        postArrayList.add(post);
    }
}
