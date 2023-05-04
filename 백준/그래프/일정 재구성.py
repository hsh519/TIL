# 리트 코드 332번 - 일정 재구성

from pip import List

class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        res = []

        def dfs(s, visit):
            res.append(s)
            if(len(tickets) == len(visit)):
                return
            rest = []
            for l in tickets:
                if(l[0] == s):
                    rest.append(l)
            if (not rest):
                res.pop()
                visit.pop()
                return
            rest.sort()
            tmp = len(visit[:])
            for ticket in rest:
                if(tickets.count(ticket) == visit.count(ticket)):
                    continue
                visit.append(ticket)
                dfs(ticket[1], visit)
            if(tmp == len(visit)):
                res.pop()
                visit.pop()
            return res

            
        dfs("JFK", [])

        return res