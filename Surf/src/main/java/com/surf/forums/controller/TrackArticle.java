package com.surf.forums.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.surf.forums.model.ArticleVO;
import com.surf.forums.model.ForumService;
import com.surf.forums.model.ReportVO;
import com.surf.forums.model.TrackVO;
import com.surf.members.model.MemberVO;

@Controller
@RequestMapping("/forums/trackEvent")
public class TrackArticle {
	@Autowired
	ForumService forumService;

	@RequestMapping(value = "/track", method = RequestMethod.POST)
	public @ResponseBody String track(@RequestParam String memberNo,
			@RequestParam String articleNo) {
		MemberVO memberVO = forumService.selectMember(Integer
				.parseInt(memberNo));
		ArticleVO articleVO = forumService.selectArticle(Integer
				.parseInt(articleNo));
		boolean ans = forumService.trackjudgement(memberVO, articleVO);
		TrackVO trackVO = new TrackVO();
		trackVO.setMemberVO(memberVO);
		trackVO.setArticleVO(articleVO);
		if (ans == false) {
			LocalDateTime dateTime = LocalDateTime.now();
			Timestamp stamp = Timestamp.valueOf(dateTime);
			trackVO.setDatetime(stamp);
		}
		forumService.trackOrTrackCancel(trackVO, ans);
		if (ans) {
			return "true";
		} else {
			return "false";
		}

	}

	@RequestMapping(value = "/trackJudge", method = RequestMethod.GET)
	public @ResponseBody String trackJudge(@RequestParam String memberNo,
			@RequestParam String articleNo) {
		MemberVO memberVO = forumService.selectMember(Integer
				.parseInt(memberNo));
		ArticleVO articleVO = forumService.selectArticle(Integer
				.parseInt(articleNo));
		boolean ans = forumService.trackjudgement(memberVO, articleVO);
		if (ans) {
			return "true";
		} else {
			return "false";
		}
	}

	@RequestMapping(value = "/reportInsert", method = RequestMethod.POST)
	public @ResponseBody String reportInsert(@RequestParam String memberNo,
			@RequestParam String articleNo, @RequestParam String reasno) {
		int MbrNo = Integer.parseInt(memberNo);
		int AtrNo = Integer.parseInt(articleNo);
		boolean ans = forumService.reportJudgement(MbrNo, AtrNo);
		if (ans) {
			return "true";
		} else {
			try {
				forumService.insertReport(AtrNo, MbrNo, reasno);
				return "true";
			} catch (Exception e) {
				/*新增失敗*/
				return "false";
			}
		}

	}

	@RequestMapping(value = "/reportJudge", method = RequestMethod.POST)
	public @ResponseBody String reportJudge(@RequestParam String memberNo,
			@RequestParam String articleNo) {
		int MbrNo = Integer.parseInt(memberNo);
		int AtrNo = Integer.parseInt(articleNo);
		boolean ans = forumService.reportJudgement(MbrNo, AtrNo);
		if (ans) {
			return "true";
		} else {
			return "false";
		}
	}
}
