package com.test.backend.board.controller;

import com.test.backend.board.jpa.BoardRepository;
import com.test.backend.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;


    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public List<Board> list() {

//        List<Board> boardList = new ArrayList<>();
//
//        Board bbb = new Board();
//        bbb.setAuthor("test");
//
//        boardList.add(bbb);

        return this.boardRepository.findAll();
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public Board read(@PathVariable("id") Long id) {

        return this.boardRepository.findById(id).get();
    }

    @RequestMapping(value="/regist", method = RequestMethod.POST)
    public Board regist(@RequestBody Board board) {

        return this.boardRepository.save(board);

    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public Board update(@RequestBody Board board){

        return this.boardRepository.save(board);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        this.boardRepository.deleteById(id);
    }
}
