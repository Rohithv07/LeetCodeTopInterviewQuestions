Given an absolute file path (Unix-style), shorten it to the format /<dir1>/<dir2>/<dir3>/....

Here is some info on Unix file system paths:

/ is the root directory; the path should always start with it even if it isn't there in the given path;
/ is also used as a directory separator; for example, /code/fights denotes a fights subfolder in the code folder in the root directory;
this also means that // stands for "change the current directory to the current directory"
. is used to mark the current directory;
.. is used to mark the parent directory; if the current directory is root already, .. does nothing.
Example

For path = "/home/a/./x/../b//c/", the output should be
simplifyPath(path) = "/home/a/b/c".

Here is how this path was simplified:
* /./ means "move to the current directory" and can be replaced with a single /;
* /x/../ means "move into directory x and then return back to the parent directory", so it can replaced with a single /;
* // means "move to the current directory" and can be replaced with a single /.





Solution:

def simplifyPath(path):
    if len(path) == 1:
        return path
    li = []
    
    splitted_path = path.split("/")
    
    for elements in splitted_path:
        if elements == "." or elements == "":
            continue
        elif elements == "..":
            if len(li) == 0:
                continue
            else:
                li.pop()
                
        else:
            li.append(elements)
            
    return '/' + '/'.join(li)
    
    
            
    

            
