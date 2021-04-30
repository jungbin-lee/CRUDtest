package com.booktest.test.CRUD;


import com.booktest.test.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TownBookController {
    private final TownBookService townBookService;

    @GetMapping("/api/townbook")
    public ReturnTownBook getTownBook(){
        return townBookService.getTownBook();
    }

    @PostMapping("/api/townbook/{userid}")
    public ReturnTownBook createTownBook(@RequestBody TownBookDto townBookDto, @AuthenticationPrincipal User user){
        return townBookService.createTownBook(user, townBookDto);
    }

    @PutMapping("/api/townbook/{townBookId}")
    public TownBook updateTownBook(@PathVariable Long townBookId,@RequestBody TownBookDto townBookDto,@AuthenticationPrincipal User user){
        return townBookService.updateTownBook(townBookId,user, townBookDto);
    }

    @DeleteMapping("/api/townbook/{townBookId}")
    public ReturnTownBook deleteTownBook(@PathVariable long townBookId,@AuthenticationPrincipal User user) {
        return townBookService.deleteTownBook(townBookId, user);
    }
}
